Feature: Todoist Feature test

  @Tugas
  Scenario Outline: Post update section with valid json
    Given Post update section with valid json with <id>
    When Send post update section request
    Then Status code update should create be 200 OK
    And Response body page should be id <id>
    And Validate update section json schema
    Examples:
      | id         |
      | 106503663 |