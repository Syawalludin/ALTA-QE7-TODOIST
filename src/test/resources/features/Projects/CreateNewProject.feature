Feature: Projects Todoist
  #PositiveCase
  @Scenario1
  Scenario: Post create new project todoist with json
    Given Post create a valid new project
    When Send post create project request
    Then Status code is 200 OK
    And Response body should contain name "Groceries"
    And Validate project json schema validator

