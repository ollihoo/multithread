#!/usr/bin/env bash

COMMAND=$1

CONTAINER_NAME=jenkins_multithreading
ROOT_PATH=`pwd`

if [ "$COMMAND" == "stop" ]; then
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
else
    docker run -p 9000:8080 -p 50000:50000 \
           -v ${ROOT_PATH}/jenkins_home:/var/jenkins_home \
           -v /var/run/docker.sock:/var/run/docker.sock \
           -v /usr/local/bin/docker:/usr/local/bin/docker \
           --name $CONTAINER_NAME \
           jenkins/jenkins:lts
fi
