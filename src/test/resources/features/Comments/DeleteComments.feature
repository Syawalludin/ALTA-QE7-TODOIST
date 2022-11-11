Feature: Delete Comments Todoist
  @Comments
  Scenario Outline: Delete comments with valid id
    Given Task delete comments with id <id>
    When Send task delete comments request
    Then Status code is 204 No Content
    Examples:
      | id         |
      | 6342212253 |
