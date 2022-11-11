Feature: Get All Projects Todoist
  #PositiveCase
  @PositiveCase
  Scenario: Get all projects todoist
    Given Get all projects valid parameter
    When Send all projects request
    Then Status code is 200 OK
    And Validate get all projects json schema validator
