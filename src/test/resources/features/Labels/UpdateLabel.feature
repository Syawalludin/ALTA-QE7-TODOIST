Feature: Update Labels Todoist

  @Labels
  Scenario Outline: Post update label valid id
    Given Post update label valid id <id>
    When Send post update label request
    Then Status code is 404 No Content
    Examples:
      | id         |
      | 2156154810 |

