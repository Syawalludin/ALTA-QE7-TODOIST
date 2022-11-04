Feature: Login User
  @Tugas
  Scenario: Login successful
    Given User Success Login with file json
    When Send login successful
    Then Status code should be 200 OK
    And Login Response body should contain token "QpwL5tke4Pnpja7X4"
    And Validate Login successful json schema

  @Tugas
  Scenario: Login Unseccessfull
    Given User Login Unsuccess Register with file json
    When Send Login Unsuccessful
    Then Status code should be 400 Bad Request
    And Response body page should be error "Missing password"
    And Validate Login Unsuccessful json schema