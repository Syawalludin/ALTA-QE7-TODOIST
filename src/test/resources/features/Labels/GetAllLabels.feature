Feature: Get All Labels Todoist

  @Labels @PositiveCase
  Scenario: Get all labels
    Given Get all labels valid parameter
    When Send all labels request
    Then Status code is 200 OK
    And Validate get all labels json schema validator

