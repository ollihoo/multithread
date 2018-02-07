# Jenkins

This project offers a script that creates a jenkins docker for you. This is the script

    docker-jenkins.sh

To use this, it's necessary to already have installed docker on your PC. To start your
local jenkins, do

    docker-jenkins.sh start

To stop it, do

    docker-jenkins.sh stop

Jenkins is then available under http://localhost:9000.

# First Time
There are some steps to do:
* go to ```jenkins_home/secrets/initialAdminPassword``` and copy initial password.
* install all suggested plugins
* create Admin account
* install pipeline project by adding this project to Jenkins:
    * see: https://jenkins.io/doc/book/pipeline/getting-started/
    * create new project - type is 'pipeline'; name: "Build multithread project"
    * select pipeline by SCM
    * add URL to this project (https://github.com/ollihoo/multithread.git)
    * execute pipeline

# Pipeline Syntax
See https://jenkins.io/doc/book/pipeline/syntax/#declarative-pipeline

# Credentials

Create new credentials (username, password) with ID "hub.docker.com"
This ID is later used to push artifacts to the docker hub.

https://wiki.jenkins.io/display/JENKINS/Credentials+Binding+Plugin

