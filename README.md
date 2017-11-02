# README

## Aim
This project is used to execute several services and to measure the
speed of these calls. It is also used to test with jUnit5.

## Test Environment

### JUnit 5 and Mockito
Most developers are used to integrate @Mock and @InjectMocks annotations
to easily set up their testing environment. For jUnit5, this can't be used
anymore.

According to http://www.baeldung.com/mockito-junit-5-extension, there is no
integration of Mockito 2 into Junit5. Same is stated in stackoverflow:
https://stackoverflow.com/questions/40961057/how-to-use-mockito-with-junit5

To use these annotations, it's necessary to manually execute annotations.
This code snippet can do that:

```
  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
```

For usage in maven, it's necessary to add
* junit-jupiter-engine to execute tests by maven
* junit-platform-surefire-provider to provide testing environment

For more information, see [pom.xml](pom.xml).

## Jenkins

This project offers a script that creates a jenkins docker for you. This is the script

    docker-jenkins.sh
    
To use this, it's necessary to already have installed docker on your PC. To start your
local jenkins, do

    docker-jenkins.sh start
    
To stop it, do

    docker-jenkins.sh stop
    
Jenkins is then available under http://localhost:9000. 

### First Time
There are some steps to do:
* go to jenkins_home/secrets/initialAdminPassword and copy initial password.
* install all suggested plugins
* create Admin account
* install pipeline project with adding this project to Jenkins (see: https://jenkins.io/doc/book/pipeline/getting-started/)

### Pipeline Syntax

https://jenkins.io/doc/book/pipeline/syntax/#declarative-pipeline