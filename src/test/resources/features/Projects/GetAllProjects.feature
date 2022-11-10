Feature: Projects Todoist

  #PositiveCase
  @Scenario1
  Scenario: Get all projects todoist
    Given Get all projects valid parameter
    When Send all projects request
    Then Status code is 200 OK
