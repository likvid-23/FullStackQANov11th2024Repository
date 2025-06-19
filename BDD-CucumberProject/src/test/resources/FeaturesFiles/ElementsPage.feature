
Feature: DemoQA Elements page Test case

    Background:
    Given Browser should be navigated to DemoQA page
    When I click on Elements item
    Then Elements Page should be displayed

    Scenario: Fill the Text Box
        Given Navigate to Text Box
        When I fill the text boxes and submit
        Then I should find text in the box below

 Scenario: Handle the webtable
     Given Navigate to Webtables
     When I click on add button
     And I fill the Registration form and submit
     Then I should find the added record on table

    @Execute
Scenario: Handle the Check Boxes
    Given Navigate to Checkboxes page
    When I click the expand button
    Then I should find the check boxes