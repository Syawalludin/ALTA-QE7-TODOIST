Feature: Todoist Section Feature test

  @Tugas
  Scenario Outline: Delete section with id
    Given Delete section with valid id <id>
    When Send delete section with valid request
    Then Status code should with valid be 204 No Content
    Examples:
      | id        |
      | 106487301 |