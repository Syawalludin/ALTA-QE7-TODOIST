Feature: Delete Projects Todoist
  #PositiveCase
  @PositiveCase
  Scenario Outline: Delete project with valid id
    Given Task delete project with id <id>
    When Send task delete project request
    Then Status code is 204 No Content
    Examples:
      | id         |
      | 2302037359 |
