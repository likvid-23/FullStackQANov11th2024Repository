Feature: Buttons Test cases

  Background:
    Given Browser should be navigated to DemoQA page
    When I click on Elements item
    Then Elements Page should be displayed
@Execute
  Scenario: Verifying all the buttons click

    Given I should be navigated to Buttons Page
    When I click on Click Me button
    Then Corresponding confirmation message should be displayed