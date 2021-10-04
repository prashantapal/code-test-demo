### Code test - Mortage plan

The new customer centric bank Money Bin Inc. in Duckburg would like to have new product on the market. For that they need your help! There is a demand from their customers that they want to be able to borrow money and get to know the exact amount they have to pay each month over a period of time.

The CEO of the bank has given the requirement like this:
"Given a total loan of X € and a fixed yearly interest rate of Y %. The customer wants to pay the same amount each month for Z years. How much should the customer pay each month to pay off the whole debt?"

Output for each customer in file:
****************************************************************************************************
Prospect 1: CustomerName wants to borrow X € for a period of Z years and pay E € each month
****************************************************************************************************

### Setup Development Environment

- ##### Requirement
  - Java 1.8
  - Maven 3

- ##### Compile and build it
  - Use `mvn clean install`.
  - To skip test cases, use `mvn clean install -Dmaven.test.skip=true`.

- ##### Run it
   - One way is, open the project in IDE and run the class `MortageTest1Application`.
   - or, after maven build, run `java -jar target/mortage-test-1-1.0-SNAPSHOT.jar`.
   - or, after maven build, run `mvn spring-boot:run`.
   - Please note, the prospect file has been added in the resources folder, if you would like to supply the prospect file at run time, you can give the absolute file path as below.
     `java -Dprospect.file.absolutepath=<absolute file path> -jar target/mortage-test-1-1.0-SNAPSHOT.jar`

- ##### IDE
  - Import the [mortage test 1](https://github.com/prashantapal/code-test-demo/mortage-test-1) directory as Maven project using projects root 'pom.xml'.

- ##### Code style
  - No tab characters
  - Tab = 4 spaces
  - Use [EditorConfig](http://editorconfig.org/)