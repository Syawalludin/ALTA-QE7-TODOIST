Feature: Task feature with invalid parameter

  @Task
  Scenario Outline: Get An Active task with invalid parameter
    Given Get an active task with invalid <id>
    When Send Get an active task
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 106567731 |

  @Task
  Scenario Outline: Update A Task with invalid parameter
    Given Update task with json and invalid <id>
    When Send Update A Task
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 106567731 |

  @Task
  Scenario Outline: Close A Task with invalid parameter
    Given Close A task With invalid <id>
    When Send Close A Task
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 106567731 |

  @Task
  Scenario Outline: Reopen A Task with invalid parameter
    Given Reopen a task with invalid <id>
    When Send Reopen A Task
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 106567731 |

  @Task
  Scenario Outline: Delete A Task with invalid parameter
    Given Delete a task with invalid <id>
    When Send Delete A task
    Then Status code should be 404 Not Found
    Examples:
      | id         |
      | 106567731 |