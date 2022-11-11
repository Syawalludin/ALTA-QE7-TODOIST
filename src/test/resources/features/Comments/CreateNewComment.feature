Feature: Create New Comment Todoist
  @Comments
  Scenario: Post create new comment todoist with json
    Given Post create a valid new comment
    When Send post create comment request
    Then Status code is 200 OK
    And Response body should contain name Comment "Need one bottle of milk"
    And Validate create comment json schema validator

