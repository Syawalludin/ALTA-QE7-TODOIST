Feature: Get Project Todoist
  #PositiveCase
  @Scenario1
  Scenario Outline: Get project valid id
    Given Get project valid id <id>
    When Send get project request
    Then Status code is 200 OK
    And Validate get project json schema validator
    Examples:
      | id         |
      | 2302129495 |
