Feature: Login Logout feature

  Scenario: Verifying Login Logout Functionality
    Given Login page should have opened for the user
    When I fill the credentials and click submit
    Then User should be login to homepage
