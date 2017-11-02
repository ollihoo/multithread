#!/usr/bin/env bash

COMMAND=$1

CONTAINER_NAME=jenkins_multithreading
ROOT_PATH=`pwd`

if [ "$COMMAND" == "stop" ]; then
    docker stop jenkins_multithreading
else
    docker run -p 9000:8080 -p 50000:50000 \
           -v ${ROOT_PATH}/jenkins_home:/var/jenkins_home \
           --name $CONTAINER_NAME \
           jenkins/jenkins:lts
fi
#
## docker exec -it sleepy_meninsky bash