# Selenium Java Framework

Sample Selenium automation framework built with Java, Maven, TestNG, Page Object Model, ExtentReports, and JSON-based test data.

This repository is a learning/demo project, not a production-ready automation framework. It shows the basic structure and flow of a UI test framework for an ecommerce application hosted at `https://rahulshettyacademy.com/client`.

## Tech Stack

- Java 17
- Maven
- Selenium 4
- TestNG
- ExtentReports
- Jackson Databind
- Cucumber dependencies included

## What This Project Demonstrates

- Browser setup through a common base test
- Page Object Model with reusable page classes
- TestNG test organization and suite XML files
- Data-driven tests using JSON
- Retry logic for unstable tests
- ExtentReports integration through TestNG listeners

## Project Structure

```text
src/main/java
  AbstractComponent/
  PageObjects/

src/test/java
  Cucumber/
  Data/
  Resources/
  StepDefinisions/
  Testcomponents/
  Testing/

TestSuite/
reports/
```

## Key Classes

- `Testcomponents.BaseTest`: driver setup, app launch, JSON reader, screenshot capture
- `AbstractComponent.AbstractComponents`: common waits and top navigation actions
- `PageObjects.*`: page object classes for login, product catalog, cart, checkout, and orders
- `Testcomponents.Listeners`: TestNG listener for ExtentReports and failure screenshots
- `Testing.SubmitOrder`: data-driven happy path purchase flow
- `Testing.Errorvalidation`: invalid login validation
- `Testing.SmokeTest`: simple navigation smoke flow

## Prerequisites

- Java 17 installed
- Maven installed and available on `PATH`
- Chrome or Edge installed locally
- Internet access to reach the demo application

## Configuration

Browser selection is read from:

- `src/test/java/Resources/GlobalData.properties`

Current value:

```properties
browser="chrome"
```

The framework also allows overriding the browser through a JVM system property:

```bash
mvn test -Dbrowser=chrome
```

For headless execution, the code expects values such as `chromeheadless` or `edgeheadless`.

## Test Data

Purchase test data is stored in:

- `src/test/java/Data/PurchaseData.json`

The `SubmitOrder` test reads this JSON and executes against multiple data sets.

## Running the Tests

Run the default Maven test phase:

```bash
mvn test
```

Run the TestNG regression-style suite configured in Maven profile `Regression`:

```bash
mvn test -PRegression
```

Run the purchase-focused suite:

```bash
mvn test -PPurchase
```

Run the smoke suite:

```bash
mvn test -PSmokeTest
```

Run with a browser override:

```bash
mvn test -PRegression -Dbrowser=chrome
```

## Reports

After execution, reports are generated under:

- `reports/report.html`
- `test-output/`
- `target/surefire-reports/`
