# Grafana

## Installation:
In this project, there is a docker-compose file that does the proper
setup. Simply do 

    docker-compose up
    
on the root directory. This also installs influxdb.

## Usage
You can reach you local grafana installation via

http://localhost:3000

The installation needs a login which is user 'admin' and password 'admin'.
To change this, do vagrant ssh and change /etc/grafana/grafana.ini as root.

## Reference
* http://docs.grafana.org/installation/rpm/

