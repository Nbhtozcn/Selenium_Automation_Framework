Feature: Nescafe

  Scenario Outline: TC_01 Verify the product price on Nescafe's official website (nescafe.com.tr) and on Migros website (https://www.migros.com.tr/) is the same
    Given I open the web browser and navigate to "https://www.nescafe.com.tr"
    When I click on the Satin Al button
    And I select Migros Sanal Market from desired supermarket brand options
    And And I extract the price and name displayed on the nescafe.com website for at index "<Index>"
    And I navigate to the selected supermarket's website
    And I extract the price and name displayed on the supermarket's website
    Then I compare the prices and the names to see if they are the same
    Examples:
      | Index |
      | 0     |
      | 1     |
      | 2     |
      | 3     |
