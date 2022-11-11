Feature: Todoist Section Feature test

  @Tugas
  Scenario Outline: Get all section with valid project id
    Given Get all section with valid project <id>
    When Send get all section request
    Then Status code should be 200 OK
    And Validate get all section json schema
    Examples:
      | id         |
      | 2302160130 |

