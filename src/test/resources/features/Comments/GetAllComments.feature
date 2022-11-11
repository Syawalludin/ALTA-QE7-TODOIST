Feature: Get All Comments Todoist
  @Comments
  Scenario: Get all comments todoist
    Given Get comment valid id <id>
    When Send all comments request
    Then Status code is 200 OK
    And Validate get all comments json schema validator
