Feature: Get Label Todoist

  @Labels @PositiveCase
  Scenario Outline: Get label valid id
    Given Get label valid id <id>
    When Send get label request
    Then Status code is 200 OK
    And Validate get label json schema validator
    Examples:
      | id         |
      | 2163176377 |
