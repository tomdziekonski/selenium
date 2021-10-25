Feature: Open HR Logging In
  Scenario: Logging in with valid Username and Password
    Given User opens the Login Page
    When Login Page web elements are available
    Then User provides a valid Username, valid Password and clicks on the Login button
    And User lands on the Home Page

  Scenario: Logging out
    Given User is logged in
    When User clicks on the logout button
    Then User is logged out
