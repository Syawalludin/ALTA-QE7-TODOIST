Feature: Get All Comments Todoist
  @Comments
  Scenario: Get all comments todoist
    Given Get all comment valid task id
    When Send all comments request
    Then Status code is 200 OK
    And Validate get all comments json schema validator
