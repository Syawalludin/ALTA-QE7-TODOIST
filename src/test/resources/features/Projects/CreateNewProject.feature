Feature: Create New Projects Todoist
  #PositiveCase
  @PositiveCase
  Scenario: Post create new project todoist with json
    Given Post create a valid new project
    When Send post create project request
    Then Status code is 200 OK
    And Response body should contain name "Groceries"
    And Validate create project json schema validator

