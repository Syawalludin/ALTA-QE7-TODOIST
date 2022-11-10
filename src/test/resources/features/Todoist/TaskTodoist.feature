Feature: Task feature

  Scenario: Get Active Task
    When Send Get Active Task
    Then Status code should be 200 OK

  Scenario Outline: Create A New Task
    Given Get list user with file json
    When Send Create Active Task
    Then Status code should be 200 OK
    And Respose body Should contain name <content> and date <date> and priority <priority>
    Examples:
      | content    | date                | priority |
      | "Buy Milk" | "tomorrow at 12:00" | 4        |

  Scenario Outline: Get An Active task
    Given Get an active task with <id>
    When Send Get an active task
    Then Status code should be 200 OK
    And Respose body should be <id>
    Examples:
      | id         |
      | 6334890386 |

  Scenario Outline: Update A Task
    Given Update task with valid json and <id>
    When Send Update A Task
    Then Status code should be 204 NoContent
    Examples:
      | id         |
      | 6334890386 |

  Scenario Outline: Close A Task
    Given Close A task With <id>
    When Send Close A Task
    Then Status code should be 204 NoContent
    Examples:
      | id         |
      | 6334890386 |