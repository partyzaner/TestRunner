# TestRunner
To run test you should add to .pom - file following code:

1) Repository:
```xml
  <repositories>
    <repository>
      <id>sabaleuski</id>
      <url>http://maven.sabaleuski.com/maven2/</url>
    </repository>
  </repositories>
```
2) Dependency:
```xml
<dependency>
  <groupId>com.sabaleuski</groupId>
  <artifactId>test-runner</artifactId>
  <version>1.2</version>
</dependency>
```

In your code:
```java
import com.sabaleuski.TestRunner;


...

public class Runner {

    public static void main(String [] args) throws XMLParseException {
        TestRunner.parseCmd(args);
        List<Class> listeners = new ArrayList<>();
        listeners.add(HTMLReporter.class);
        listeners.add(TestListener.class);
        TestRunner.runTests(ProjectConstants.TESTNG_FILE, listeners);
    }
}

```