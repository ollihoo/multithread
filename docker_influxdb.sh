#!/usr/bin/env bash

COMMAND=$1

CONTAINER_NAME=influxdb_multithreading
ROOT_PATH=`pwd`

if [ "$COMMAND" == "stop" ]; then
    docker stop jenkins_multithreading
else
    docker run -p 8086:8086  \
           -v ${ROOT_PATH}/influxdb:/var/lib/influxdb \
           --name $CONTAINER_NAME \
           influxdb
fi
