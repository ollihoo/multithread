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

To get these tests separated from unit tests, I added a package called 'integrationtests'.
To integrate all tests, I have to configure failsafe plugin:



Reference: http://maven.apache.org/surefire/maven-failsafe-plugin/examples/inclusion-exclusion.html

