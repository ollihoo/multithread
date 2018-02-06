# README

This project is used to execute several services and to measure the
speed of these calls. It is also used to test with jUnit5.

## Getting started
In this project root directory, do 

    ./mvnw package
    docker-compose up
    
This compiles and start the application and all monitoring tools within docker
components. You can then use the application itselve by browsing to this address:

    http://localhost:8081/task 

Attention: it's port 8081!! That's important because the monitoring setup only can
see this docker application at the moment.


## Metrics
Metrics is the main topic of this project. See
this page for more information: [docs/metrics.md](docs/metrics.md).

You can start monitoring via the docker-compose command you see above.

## Test Environment
In this project I evaluated JUnit5 plus Mockito. Summary: it was a bad idea (see: [docs/junit5.md](docs/junit5.md)).

To work with junit4, see [docs/junit4.md](docs/junit4.md).

## Maven Wrapper
See https://howtoprogram.xyz/2016/09/11/maven-wrapper-example/

Instead of using mvn, simply use

    ./mvnw test

With this feature, there is only Java SDK needed on Jenkins servers.

## Jenkins

This project offers a script that creates a jenkins docker for you. This is the script

    docker-jenkins.sh
    
For more information, go to [docs/jenkins.md](docs/jenkins.md)