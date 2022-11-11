Feature: Update Comments Todoist
  @Comments
  Scenario Outline: Post update comment valid id
    Given Post update comment valid id <id>
    When Send post update comment request
    Then Status code is 204 No Content
    Examples:
      | id         |
      | 3170522276 |