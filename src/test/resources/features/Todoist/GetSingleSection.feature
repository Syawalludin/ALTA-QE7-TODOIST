Feature: Todoist Feature test

  @Tugas
  Scenario Outline: Get single section with valid id
    Given Get single section with valid <id>
    When Send get single section request
    Then Status code single section should be 200 OK
#    And Response body single section page should be <id>
    Examples:
      | id        |
      | 106487042 |