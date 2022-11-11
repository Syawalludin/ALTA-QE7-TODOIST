Feature: Get Comment Todoist
  @Comments
  Scenario Outline: Get comment valid id
    Given Get comment valid id <id>
    When Send get comment request
    Then Status code is 200 OK
    And Validate get comment json schema validator
    Examples:
      | id         |
      | 3170522276 |
