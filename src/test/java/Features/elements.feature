@Tests
Feature: Feature to test Elements from ToolsQA

  Scenario:Testing Check-Box feature
    Given I Set the homepage for demoQA website
    When I click on the Elements button
    When I click on Check box button
    When I click in the Check-box Workspace and Notes
    Then I receive the message with what i selected

  Scenario: Testing Radio Button feature
    Given I Set the homepage for demoQA website
    When I click on the Elements button
    When I click on RadioButton button
    When I click on YES
    Then I see the message that says i selected Yes





