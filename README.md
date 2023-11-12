# Playwright Java TestNG Automation Project 

## Installation Steps

In order to use the framework:

- Fork the repository.
- Clone, i.e, download your copy of the repository to your local machine using
```
gh repo clone IriSamo/JavaPlaywrightLuma
```
- Import the project in IntelliJ IDEA.

## Languages and Frameworks

The project uses the following:

- *[Java 17](https://openjdk.org/projects/jdk/17/)* as the programming language.
- *[Maven](https://maven.apache.org/index.html)* as a builder and manager of project.
- *[Playwright](https://playwright.dev/)* as the framework for Web Testing and Automation.
- *[TestNG](https://testng.org/doc/)* as the Testing Framework.
- *[IntelliJ IDEA](https://www.jetbrains.com/idea/)* as the Integrated Development Environment.

## Project Structure

The project is structured as follows:

```bash
📦:.
└───test
    └───java

```

#
## Key Notes

### Framework Design

#
### Test Design
- Each test in the [tests package](./src/test/java/) is independent and complete.
- [BaseTest](./src/test/java/BaseTest.java) class uses the TestNG configuration annotations for set up and tear down.
    - **@BeforeClass** : clean up results directory, Initialize the extent reports, logger and read test properties.
    - **@BeforeMethod** : Start the playwright server, instantiate the page and navigate to the website.
    - **@AfterMethod** : Stop the tracing (if enabled), close the page instance.
    - **@AfterClass** : This method used in each Test class to close the browser and the playwright server.
- For each Test new playwright server is launched which is isolated from other playwright instance.

#
### Test Execution 
- The tests can be executed from maven test command or individual TestNG test from local after cloning the repo.
- maven commands
     ```command
     
       mvn clean test                                    / To run all the unit tests

       mvn test -Dtest=testClasseName                    / To run a single test class

       mvn test -Dtest=testClasseName#testMethodName     / To run a specific methods within test classes

     ```
- The tests can be executed uses *TestNG* as the test runner. Check [this implementation](./src/test/java/io/github/tahanima/e2e/LoginE2ETest.java) for reference.
       
#
### Reporting
To see the report, go to the target/surefire-reports/index.html or target/surefire-reports/emailable-report.html

#
### GitHub Actions
- Workflow: workflow_dispatch is used in workflow, so the test can be executed triggered from actions ui
By default, the test will be executed on Ubuntu runner with headless mode.
