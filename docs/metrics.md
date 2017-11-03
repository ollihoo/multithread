# Metrics
One of the main reason to implement this project is metrics measurement.
This project uses actuator package by Spring Boot to do measurement.

Reference: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready.html

## TICK stack
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

For the first time, you need to set up a database.

## Telegraf
Telegraf ist the collector of metrics. In my configuration, I use the
jolokia interface to get data. This means that Spring Boot offers this URL:

    http://localhost:8080/jolokia

Telegraf has a plugin for this interface. The configuration for this
environment can be found here: [telegraf/telegraf.conf](../telegraf/telegraf.conf)

When influxD runs, start telegraf, i.e.

    cd telegraf
    ./telegraf -config telegraf.conf

You can easily check if this works by checking the influxDB. See
[influxdb.md](influxdb.md) for more information.

## References

### Overview
* https://stackoverflow.com/questions/32656246/exposing-spring-boot-metrics-to-influxdb-for-grafana-visualization

### Telegraf
* [How to configure Telegraf - ext: stackoverflow](https://stackoverflow.com/questions/32656246/exposing-spring-boot-metrics-to-influxdb-for-grafana-visualization)

### Jolokia
* https://jolokia.org/
* https://github.com/influxdata/telegraf


