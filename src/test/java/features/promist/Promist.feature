Feature: Promist

  Scenario: Login
    Given I am logged in to my proticaret account

  Scenario: Adding a product to the cart
    Given I am logged in to my proticaret account
    When I click on Urunlerimiz button
    And Click b2cETicaretPaketleri from dropdown menu
    And I close the popup
    When I click on Satin Al button for Standart option and add to cart
    Then I should see the product is in the Cart

  Scenario: Update the product from the cart
    Given I am logged in to my proticaret account
    When I go to my cart
    And I change the product name and save
    Then I should see the updated quantity and price accordingly


  Scenario: Delete the product from the cart
    Given I am logged in to my proticaret account
    When I go to my cart
    And Click on delete button
    Then I should see the product removed from the cart

