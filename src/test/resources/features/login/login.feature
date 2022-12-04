Feature: As a user I should be able to login with valid credentials

  Scenario: Login into the application with valid credentials
  	Given I am on the Login page URL
    Then I click on login as user button and wait for login page
    Then I should see login Page
    When I enter username
    And I enter password
    And click on login button
    Then I should verify the welcome page title
