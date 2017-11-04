# JUnit 4

JUnit 4 offers the annotation @Category(...). I split up tests in

* unit tests
* integration tests

To mark system tests, I create this interface IntegrationTest. By annotating
tests with

    @Category(IntegrationTest.class)
    
It's possible to exclude tests from ```mvn test```.

The exclusion is done in the surefire plugin:

            <plugin>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.19.1</version>
                <configuration>
                    <excludedGroups>de.hoogvliet.IntegrationTest</excludedGroups>
                </configuration>
            </plugin>
