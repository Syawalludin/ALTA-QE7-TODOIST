Feature: Testing GET User
  @Tugas
  Scenario Outline: Get Single
    Given Get single user with <id>
    When Send get single user
    Then Status code should be 200 OK
    And Response Single User body page should be <id>
    And Validate Get single user json scema
    Examples:
      | id |
      | 2  |

  @Tugas
  Scenario Outline: Get single User Not Found
    Given Get single user not found with <id>
    When Send get single user Not Found
    Then Status code should be 404 Not Found
    And Response body should be NULL
    And Validate Get single user Not Found json scema
    Examples:
      | id |
      | 23 |

  @Tugas
  Scenario Outline: List Resource
    Given Get List Resource with parameter page <page>
    When Send Get List Resource request
    Then Status code should be 200 OK
    And Response List Resource body page should be <page>
    And Validate List Resource json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas
  Scenario Outline: Single Resource
    Given Get single resouce with <id>
    When Send get single resouce
    Then Status code should be 200 OK
    And Response Single resouce body page should be <id>
    And Validate Single resource json schema
    Examples:
      | id |
      | 2  |