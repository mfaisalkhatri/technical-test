## Don't forget to give a :star: to make the project popular.

## :question: What is this Repository about?

- This repo contains example code for [Tendable](https://www.tendable.com/) website's tech challenge.
- Maven is used as build tool in this project.
- TestNG is used as testing framework for organizing and running tests and performing Assertions.
- [Data Faker library](https://www.datafaker.net/) is used for setting the fake data while filling up the form.

## Test Covered in this project

1. All the tests are written in the `TendableWebSiteTests` class.
1. The first test `testTopLevelMenus()` verifies that the top level menus, i.e `Home`, `Our Story`, `Our Solution`
   and  `Why Tendable` are present and accessible.
1. The second test `testPresenceOfRequestADemoButton()` checks that the `Request a Demo` button is present and active on
   the following pages:
    - Home
    - Our Story
    - Our Solution
    - Why Tendable
1. The third test `testContactMarketing()` navigates to the `ContactUs` page, chooses `Marketing` and fills the form
   leaving the `Message` field empty.
   An assertion is performed on the error message `Sorry, there was an error submitting the form. Please try again.`

## Test Strategy

1. Page Object model has been used in this project as it helps in better readability and maintainability. Hence,
   separate page classes have been created that houses the WebElements of the respective page.
1. `BasePage` class has the common WebElements that are available on multiple pages on the website. The `Request a Demo`
   button's
   WebElement is updated in this class. This Base Page class is extended by all other page object classes as it gives
   flexibility to re-use the BasePage class methods and variables easily.
1. For filling the `Contact Us` form, Data Faker library has been used as it takes care of passing the fresh data in the
   test everytime the tests are run. So, we don't have to worry about the test data generation.
1. `DriverManager` class has been created to take care of the drivers required to run the test. Currently, Chrome,
   Firefox and Edge browsers are supported in this project.
1. `BaseTest` class is created that instantiates the DriverManager class and passes the browser name using the
   `@Parameter` annotation in TestNG. In `BaseTest` class, the browser name supplied from `testng.xml` will actually be
   passed in the `startBrowser()` method from the `DriverManager` class and the respective browser session will be
   started.

## Running the Tests

1. To run the test from command line use the following command:

    - `mvn clean test`

2. To run the tests using TestNG in intelliJ:

    - Right click on `testng.xml` and select `Run '...\testng.xml`

## 🧬 Need Assistance?

- Discuss your queries by writing to me @ `mohammadfaisalkhatri@gmail.com`
  OR ping me on any of the social media sites using the below link:
    - [Linktree](https://linktr.ee/faisalkhatri)

### :thought_balloon: Checkout the blogs related to Testing on [Medium](https://medium.com/@iamfaisalkhatri), [My Website](https://mfaisalkhatri.github.io) and [LambdaTest blogs](https://www.lambdatest.com/blog/author/mfaisalkhatri/)

### :bookmark: Checkout videos related to Software Testing and Test automation tools on [Testing Talks with Faisal Khatri](https://www.youtube.com/@faisalkhatriqa)