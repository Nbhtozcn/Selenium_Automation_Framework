Feature: Nobel Yayin

  Background:
    Given The user is on the homepage
    And The user select English as language

  Scenario: TC_01 Validate free shipping is applied for orders over 400₺
    When I click on Education button from Categories
    And I select Descending by Price
    And I click Add to Cart button for the first book priced over 400
    When I proceed to checkout
    Then I should see that the shipping fee is 0,00₺


  Scenario: TC_02 Validate shipping fee is applied for orders under 400₺
    When I click on Education button from Categories
    And I click Add to Cart button for the first book priced less than 400
    When I proceed to checkout
    Then I should see the shipping fee calculated as 27,00₺









