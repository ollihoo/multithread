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

For more information, see pom.xml.