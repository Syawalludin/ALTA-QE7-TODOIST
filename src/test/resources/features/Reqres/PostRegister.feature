Feature: Register User
  @Tugas
  Scenario Outline: Regiter successful
    Given User Success Register with file json
    When Send register successful
    Then Status code should be 200 OK
    And Response body should contain id <id> and token "QpwL5tke4Pnpja7X4"
    And Validate Register Successful json scema
    Examples:
      | id |
      | 4  |

  @Tugas
  Scenario: Register Unsuccessfull
    Given User Unsuccess Register with file json
    When Send register Unsuccessful
    Then Status code should be 400 Bad Request
    And Response body page should be error "Missing password"
    And Validate Register Unsuccessful json scema
