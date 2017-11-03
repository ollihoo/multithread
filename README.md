# README

This project is used to execute several services and to measure the
speed of these calls. It is also used to test with jUnit5.

## Metrics
Metrics is the main topic of this project. It's alos complex. See
this page for more information: [docs/metrics.md](docs/metrics.md).

When running application, there should be this interface available:

    http://localhost:8080/jolokia

Start InfluxDB and Telegraf to get metrics.

## Test Environment
In this project I evaluate JUnit5 plus Mockito.
You'll find more information here: [docs/junit5.md](docs/junit5.md).

## Maven Wrapper
See https://howtoprogram.xyz/2016/09/11/maven-wrapper-example/

Instead of using mvn, simply use

    ./mvnw test

With this feature, there is only Java SDK needed on Jenkins servers.

## Jenkins

This project offers a script that creates a jenkins docker for you. This is the script

    docker-jenkins.sh
    
For more information, go to [docs/jenkins.md](docs/jenkins.md)