Feature: Projects Todoist

  @Scenario1
  Scenario: Get all projects todoist
    When Get all projects request
    Then Status code is 200 OK
