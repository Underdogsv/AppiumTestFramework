# AppiumTestFramework 
This has been developed for mobile testing and can be expanded according to needs and testing purposes

Technologies/Tools used in building the framework
=================================================
- IntelliJ - IDE
- Appium - Mobile Automation library
- Maven - Build automation tool
- Java - Programming language
- Cucumber - BDD
- Gherkin - DSL
- TestNG - Unit testing framework
- Log4J - Logging framework
- Cucumber Report 
- JSON - Test Data
- Gson - Convert Java Objects into their JSON
- GitHub - Version control
  
Design patterns used in the framework
=================================================
- Factory Method pattern - Appium driver part
- Behaviour Driven Development - Cucumber part
- DDT - Application behaviour verification using generated test data 
  

You can execute test from command line using:
- mvn clean test

Aslo using command line you can run tests 
and set some configuration variable (e.g deviceName, IP-addess, port,):
- mvn clean test -DipAddress={your address}

After execution of the scripts framework will provide you cucumber report in ease to understand view:
https://reports.cucumber.io/reports/5b73823d-dd65-4ee5-95b2-8abb02131d00


