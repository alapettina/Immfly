Feature: Check the items order

  @Scenario
  Scenario Outline: Check the sort
    Given the user go to the page speedbird-cafe
    When the user select the filter <filter> and the option <options>
    And the user do a sort choosing the option <sortBy>
    And the user change the order by <orderOption>
    Then the user check the order of the elements is depending the sort price and order <orderOption>
    Examples:
      | sortBy | orderOption | filter   | options     |
      | Price  | Descending  | Category | Snack Boxes |

