Feature: DemoQA Elements page Test case

    Background:
    Given Browser should be navigated to DemoQA page
    When I click on Elements item
    Then Elements Page should be displayed

    Scenario: Fill the Text Box
        Given Navigate to Text Box
        When I fill the text boxes and submit
        Then I should find text in the box below




