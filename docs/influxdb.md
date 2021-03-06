# InfluxDB
* https://docs.influxdata.com/influxdb/v1.3/introduction/getting_started/
* tested version: 1.3.7

## Installation

### docker

    docker pull influxdb
    
In this project, there is a docker-compose file that does the proper
setup. Simply do 

    docker-compose up
    
on the root directory. This also starts grafana.

### RPM

See [Vagrantfile](../monitoring/Vagrantfile) for more information.

### Windows:

    wget https://dl.influxdata.com/influxdb/releases/influxdb-1.3.7_windows_amd64.zip
    unzip influxdb-1.3.7_windows_amd64.zip

### First Steps
Start influxd.exe; under Windows you will see a cmd window with log file.

* Use CLI via influx.exe or similar
* CREATE DATABASE multithreading
* SHOW DATBASES // check if multithreading has been created
* USE multithreading

### Basic concept
InfluxDB saves time series data; this unit is called "data point".Primary key
is always time. 'tags' and 'fields' are columns, 'tags' are indexed.

Data Points are written in Line Protocol:

    <measurement>[,<tag-key>=<tag-value>...] <field-key>=<field-value>[,<field2-key>=<field2-value>...] [unix-nano-timestamp]

* measurement: in SQL speech, it's the table
* tag: this is the indexed column
* field: this is the unindexed column
* unix-nano-timestamp: if not provided, influxdb uses 'now'


To insert data, you can use this command:

    INSERT cpu,host=serverA,region=us_west value=0.64

'measurement' is 'cpu'. tags are 'host' and 'region'. These tags are indexed.
Field 'value' is saved in a separate column, but not indexed.

To get data:

    SELECT "host", "region", "value" FROM "cpu"

Further information: see link above.

## See measurements

    > show measurements
    name: measurements
    name
    ----
    cpu
    jolokia
    mem

## See values of the multithreading applications

Use the influxDB CLI

    use multithreading
    select * from jolokia
    select multithreading_threads from jolokia;

## See field of a table

    show field keys

# References
* https://portal.influxdata.com/downloads