Feature: Post Update Project Todoist
  #PositiveCase
  @Scenario1
  Scenario Outline: Post update project valid id
    Given Post update project valid id <id>
    When Send post update project request
    Then Status code is 200 OK
    And Validate post update project json schema validator
    Examples:
      | id         |
      | 2302129495 |