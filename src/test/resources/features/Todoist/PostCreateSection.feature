Feature: Todoist Feature test

  @Tugas
  Scenario Outline: Post new section with valid body
    Given Post new section with valid body
    When Send post new section request
    Then Status code should create be 200 OK
    And Response body page should contain project_id <project> and name <name>
    And Validate create section json schema
    Examples:
      | project    | name        |
      | 2302160130 | "Groceries" |