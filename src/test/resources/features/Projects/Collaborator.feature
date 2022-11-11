Feature: Collaborator Projects Todoist
  #PositiveCase
  @PositiveCase
  Scenario Outline: Collaborator project with valid id
    Given Collaborator project with id <id>
    When Send collaborator project request
    Then Status code is 200 OK
    And Validate collaborator all project json schema validator
    Examples:
      | id         |
      | 2302207007 |
