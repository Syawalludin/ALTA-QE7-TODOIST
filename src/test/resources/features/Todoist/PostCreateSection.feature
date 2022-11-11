Feature: Todoist Feature test

  @Tugas
  Scenario : Post new section with valid json
    Given Post new section with valid json
    When Send post new section request
    Then Status code should create be 200 OK
    And Response body page should contain id <id> and project_id <project> and order <order> and name <name>
    And Validate create section json schema
    Examples:
      | id        | project    | order | name        |
      | 106506529 | 2302172069 | 3     | "Groceries" |
