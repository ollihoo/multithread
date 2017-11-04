# JUnit 4

JUnit 4 offers the annotation @Category(...). I split up tests in

* unit tests
* integration tests


# Maven
Maven offers different plugins for these test stages:
* unit tests - Surefire plugin
* integration test - Failsafe plugin


# Unit Tests
These tests don't get any @Category annotation (see below). There is no special
configuration needed in the classes. in pom.xml there is an exclusion of
IntegrationTest category in the Surefire plugin:

            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.19.1</version>
                <configuration>
                    <excludedGroups>de.hoogvliet.IntegrationTest</excludedGroups>
                </configuration>
            </plugin>
    
This excludes all marked tests from ```mvn test```.


#Integration Tests
To mark integration tests, I create this interface IntegrationTest. By annotating
tests with

    @Category(IntegrationTest.class)

it's possible to separate them from unit tests. 
I also added a package called 'integrationtests'. To get them executed, there is another
command ```mvn verify```. This is done by this configuration:

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-failsafe-plugin</artifactId>
                <configuration>
                    <includes>
                        <include>**/integrationtests/**.java</include>
                    </includes>
                    <groups>de.hoogvliet.IntegrationTest</groups>
                </configuration>
                <executions> 
                    ...
                </executions>
            </plugin>

As a concept, integration tests should not start Spring Boot application themselves. 
During development, tests need to be implemented against the running local instance. For
tests in Jenkins, it's necessary to start another local instance by maven.

This is done via spring-boot-maven-plugin. It integrates to the failsafe plugin stages
'pre-integration-test' and 'post-integration-test'.

See [pom.xml](../pom.xml) for more details.


# References
* http://maven.apache.org/surefire/maven-failsafe-plugin/examples/inclusion-exclusion.html
* https://docs.spring.io/spring-boot/docs/current/maven-plugin/usage.html
