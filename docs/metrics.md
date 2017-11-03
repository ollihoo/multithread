# Metrics

## Overview
This project uses actuator package by Spring Boot to do measurement.
The goal is to show metrics in a grafana board.

The way from Spring Boot to grafana is this one:
* use Spring Boot actuator; it offers a jolokia interface that is used
* use Telegraf to collect data via Jolokia; data is written to InfluxDB
* grafana uses InfluxDB as data source to show dashboards


For demonstration issues, I want to get this environment completely on
one laptop. This makes it a little bit more complicated:
* I use IntelliJ as IDE; this is the place I start Spring Boot application
* I use telegraph.exe with the local telegraf.conf (see below)
* I use vagrant to set up a centos environment; it contains influxDB and
  grafana (see [Vagrantfile](../Vagrantfile)


## Background: TICK stack
Influxdata is a company with a stack of tools to get, save and display metrics.
This environment is called TICK stack:
* Telegraf: collect and report metrics and events to InfluxDB
* InfluxDB: time series database to collect data
* Chronograf: Interface for access restrictions, dashboards etc.
* Kapacitor: Real-time streaming data processing engine.

More information: https://www.influxdata.com/time-series-platform/

For my issue I want to use InfluxDB and Telegraf.

## InfluxDB
This topic needs more documentation. See [influxdb.md](influxdb.md)

## Telegraf
Telegraf ist the collector of metrics. In my configuration, I use the
jolokia interface to get data. This means that Spring Boot offers this URL:

    http://localhost:8080/jolokia

Telegraf has a plugin for this interface. The configuration for this
environment can be found here: [telegraf/telegraf.conf](../telegraf/telegraf.conf)

Start telegraf, i.e.

    cd telegraf
    ./telegraf -config telegraf.conf

You can easily check if this works by checking the influxDB. See
[influxdb.md](influxdb.md) for more information.

## References

### Overview
* https://stackoverflow.com/questions/32656246/exposing-spring-boot-metrics-to-influxdb-for-grafana-visualization
* https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready.html

### Telegraf
* [How to configure Telegraf - ext: stackoverflow](https://stackoverflow.com/questions/32656246/exposing-spring-boot-metrics-to-influxdb-for-grafana-visualization)

### Jolokia
* https://jolokia.org/
* https://github.com/influxdata/telegraf


