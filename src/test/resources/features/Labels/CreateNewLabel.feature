Feature: Create New Label Todoist

  @Labels
  Scenario: Post create new label todoist with json
    Given Post create a valid new label
    When Send post create label request
    Then Status code is 200 OK
    And Response body should contain name "Junkfood"
    And Validate create label json schema validator

