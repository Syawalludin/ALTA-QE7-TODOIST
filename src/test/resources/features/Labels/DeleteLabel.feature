Feature: Delete Labels Todoist

  @Labels
  Scenario Outline: Delete labels with valid id
    Given Task delete label with id <id>
    When Send task delete label request
    Then Status code is 204 No Content
    Examples:
      | id         |
      | 2302037359 |


