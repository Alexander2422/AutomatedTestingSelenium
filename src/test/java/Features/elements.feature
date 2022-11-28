Feature: Feature to test Elements from ToolsQA

  @Tests
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


  Scenario: Testing Web Tables add , edit and delete feature
    Given I Set the homepage for demoQA website
    When I click on the Elements button
    When I click on Web Tables button
    When I click on ADD
    When I write all the new entries
    Then I check to see if new entry is added
    When I press on edit on the new entry and change the name
    Then I check to see if name was changed successfully
    When I press on delete of the new entry
    Then I check to see if last entry was removed





