Feature: Feature to test Forms from ToolsQA

@Tests
  Scenario: Testing adding inputs into Practice form
    Given I Set the homepage for demoQA website
    When I click on Forms button
    When I click on Practice form
    When I input all the information in the student form
    Then I check to see if all information is correct