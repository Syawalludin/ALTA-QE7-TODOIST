
Feature: Reqres feature GET
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameters page <page>
    When Send Get list user request
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json scema
    Examples:
    | page |
    | 1    |
    | 2    |

  @Latihan
  Scenario: Post create users
    Given Post create user with valid json
    When Send post create user request
    Then Status code should be 201 Created
    And Response body should contain name "Syawal Ludin" and job "QA Engineer"
    And Validate create user json scema

  @Tugas
  Scenario Outline: Put update user with json
    Given Put update user with valid json with <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body should contain name "Syawal Ludin Update" and job "QA Engineer"
    And Validate Put Update user json scema
  Examples:
    | id |
    | 1  |
    | 2  |

  @Tugas
  Scenario Outline: Delete User
    Given Delete user with <id>
    When Send delete user
    Then Status code should be 204 no content
  Examples:
    | id |
    | 2  |