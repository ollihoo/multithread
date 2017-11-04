# jUnit 5 and Mockito

## Notice

Just writing unit tests is quite easy with junit5. But with integrational
tests, i gets more and more complicated. That'S why I decided to give up
with junit5 and to skip back to junit4. Please read earlier versions of
this document to see what I found out so far.

## Introduction

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
