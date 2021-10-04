### Code test - Mortage plan

In extension to [mortage test 1](https://github.com/prashantapal/code-test-demo/tree/master/mortage-test-1), instead of reading customer details from file system, take inputs from database table.

### Setup Development Environment

- ##### Requirement
  - Java 1.8
  - Maven 3

- ##### Compile and build it
  - Use `mvn clean install`.
  - To skip test cases, use `mvn clean install -Dmaven.test.skip=true`.

- ##### Run it
   - One way is, open the project in IDE and run the class `MortageTest2Application`.
   - or, after maven build, run `java -jar target/mortage-test-2-1.0-SNAPSHOT.jar`.
   - or, after maven build, run `mvn spring-boot:run`.
   - Please note, the prospect file has been added in the [resources](https://github.com/prashantapal/code-test-demo/tree/master/mortage-test-1/src/main/resources) folder, if you would like to supply the prospect file at run time, you can give the absolute file path as below.
     `java -Dprospect.file.absolutepath=<absolute file path> -jar target/mortage-test-1-1.0-SNAPSHOT.jar`

- ##### IDE
  - Import the [mortage test 2](https://github.com/prashantapal/code-test-demo/tree/master/mortage-test-2) directory as Maven project using projects root 'pom.xml'.

- ##### Code style
  - No tab characters
  - Tab = 4 spaces
  - Use [EditorConfig](http://editorconfig.org/)