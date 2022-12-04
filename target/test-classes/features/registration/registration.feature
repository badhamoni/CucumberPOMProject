Feature: Register an unregistered user

  @Registration
  Scenario: Enter valid user details in the registration form
    Given I am on the Login page URL
    Then I click on New User! Register Here button and wait for Registration page
    Then I should see Registration Page
    And Enter person username
    And I enter password
    And I enter First Name
    And I enter Last Name
    And I enter Address
    And I enter Phone No
    And I enter Email Id
    When I click on I AGREE FOR ALL TERMS & CONDITIONS! REGISTER ME
    Then I should verify whether registration is successful or not


  @UserLogin
  Scenario: Login with the registered user
    Given User Clicks on Login Button
    When User Clicks on "Login As User"
    Then User is on login as user page
    Then user enters "<username>" and "<password>"
    Then user clicks on login as user button.
