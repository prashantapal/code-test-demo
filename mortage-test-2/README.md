### Code test - Mortage plan

In extension to [mortage test 1](https://github.com/prashantapal/code-test-demo/tree/master/mortage-test-1), instead of reading customer details from file system, take inputs from database table.

### Setup Development Environment

- ##### Requirement
  - Java 1.8
  - Maven 3

- ##### Compile and build it
  - Use `mvn clean install`.

- ##### Run it
   - One way is, open the project in IDE and run the class `MortageTest2Application`.
   - or, after maven build, run `java -jar target/mortage-test-2-1.0-SNAPSHOT.jar`.
   - or, after maven build, run `mvn spring-boot:run`.
   - Call the end point /calculate to get monthly installment of all customers.
   `curl -X GET http://localhost:8080/calculate`

- ##### Inmemory H2 database

   - H2 console: `http://localhost:8080/console`
   - Jdbc Url: `jdbc:h2:mem:testdb`
   - User name: `sa`
   - Password: `<blank>`
   - Table name: [Customer](https://github.com/prashantapal/code-test-demo/tree/master/mortage-test-2/src/main/resources/schema.sql)
   - Initial configuration: [here](https://github.com/prashantapal/code-test-demo/tree/master/mortage-test-2/src/main/resources/data.sql)

- ##### IDE
  - Import the [mortage test 2](https://github.com/prashantapal/code-test-demo/tree/master/mortage-test-2) directory as Maven project using projects root 'pom.xml'.

- ##### Code style
  - No tab characters
  - Tab = 4 spaces
  - Use [EditorConfig](http://editorconfig.org/)
