#!/usr/bin/env bash

COMMAND=$1

CONTAINER_NAME=grafana
ROOT_PATH=`pwd`

if [ "$COMMAND" == "stop" ]; then
    docker stop $CONTAINER_NAME
    docker stop $CONTAINER_NAME
else
    docker run -p 3000:3000 \
           --name=$CONTAINER_NAME \
           -v ${ROOT_PATH}/grafana:/var/lib/grafana \
           -e "GF_PATHS_CONFIG=/var/lib/grafana/grafana.ini" \
           grafana/grafana
fi
