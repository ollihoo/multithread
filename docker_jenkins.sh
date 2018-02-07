#!/usr/bin/env bash

COMMAND=$1

CONTAINER_NAME=jenkins_multithreading
ROOT_PATH=`pwd`
JENKINS_HOME=${ROOT_PATH}/jenkins_home
BOOTSTRAP_SCRIPT=root_apt_get.sh

if [ "$COMMAND" == "stop" ]; then
    docker stop $CONTAINER_NAME
    docker rm $CONTAINER_NAME
else
    if [ ! -f "$JENKINS_HOME/${BOOTSTRAP_SCRIPT}" ]; then
        cp $ROOT_PATH/src/main/scripts/${BOOTSTRAP_SCRIPT} $JENKINS_HOME/${BOOTSTRAP_SCRIPT}
    fi

    docker run -p 9000:8080 -p 50000:50000 -d \
           -v $JENKINS_HOME:/var/jenkins_home \
           -v /var/run/docker.sock:/var/run/docker.sock \
           --name $CONTAINER_NAME \
           jenkins/jenkins:lts
    docker exec -u root $CONTAINER_NAME bash /var/jenkins_home/${BOOTSTRAP_SCRIPT}

fi
