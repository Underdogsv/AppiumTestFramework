# AppiumTestFramework 
This framework has been developed for mobile testing and can be expanded according to needs and testing purposes

## Before you start the following configurations should be completed:
- Download Java
- Install Android Studio and set Android SDK path
- Download Node
- Set Java,Android SDK and Node) Home path on Windows/Mac variables.
- Configure Emulator in Android Studio
- Install and start Appium server


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
- Extend Cucumber Report
- JSON - Test Data
- Gson - Convert Java Objects into their JSON
- GitHub Actions - CI/CD
- GitHub - Version control
- JavaFaker - test data generation

  
Design patterns used in the framework
=================================================
- Factory Method pattern - Appium driver part
- Behaviour Driven Development - Cucumber part
- DDT - Application behaviour verification using generated test data 
  

You can execute tests from command line using:
- mvn clean test

Or in case below you will execute Cucumber runner with retry suit which rerun failed scenarios)
- mvn test -DxmlFilePath=TestNG  

Aslo using command line you can run tests 
and set some configuration variable (e.g deviceName, IP-address, port,):
- mvn clean test -DipAddress={your address}

After execution of the scripts framework will provide you cucumber report in ease to understand view:
https://reports.cucumber.io/reports/1b44fcda-5233-4a0c-be3e-da023f48b3a5

[Cucumber report](images/CucumberReport.PNG)

Also after local running you can go to the ExtentReports folder and check extended report

[Example of test result](images/ExtentReport1.png)

[Example of screenshot from failed step](images/ExtentReportw.png)