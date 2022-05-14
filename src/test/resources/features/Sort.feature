Feature: feature to test the confirmation functionality


  Scenario Outline: Check the sort
    Given the user go to the page speedbird-cafe
    When the user do a sort choosing the option <sortBy>
    And the user change the order by <orderOption>
    Examples:
      | sortBy | orderOption |
      | Price  | Ascending   |

