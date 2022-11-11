Feature: Todoist Feature test

  @Tugas
  Scenario Outline: Get all section with valid project id
    Given Get all section with valid project <id>
    When Send get all section request
    Then Status code should be 200 OK
    Examples:
      | id         |
      | 2302172069 |

#  Scenario Outline: Get an active task with valid parameter
#    Given Get an active task with id <id>
#    When Send Get an active tasks
#    Then Status code should be 200 OK
#    And Response body should be id 106506529
#    Examples:
#      | id         |
#      | 2302172069 |