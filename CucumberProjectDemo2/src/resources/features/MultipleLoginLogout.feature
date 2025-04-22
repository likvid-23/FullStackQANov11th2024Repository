
Feature: Login and logut feature

  Scenario Outline: Verifing Multiple Login Logout Functionality

    Given Login page should have opened for the user
    When I enter "<username>" in username text field
    And I enter "<password>" in password text field
    And I click on Login Button
    Then User should be login to homepage
    And user should close browser

    Examples:
    |username|password|
    |standard_user|secret_sauce|
    |locked_out_user|secret_sauce|
    |problem_user|secret_sauce|
