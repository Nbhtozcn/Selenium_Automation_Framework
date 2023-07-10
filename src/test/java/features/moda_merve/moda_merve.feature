Feature: Moda Merve

  Scenario: Export content from YOUR PHOTOS page to an Excel file
    Given I am on the homepage
    When I click on the YOUR PHOTOS menu
    Then I write the content of each card on the YOUR PHOTOS page to an Excel file
    And the Excel file includes the following information; Image Link,Product Link,User Information,Comment,Star Rating


  Scenario: Verify error message when entering a different password in the password confirmation field
    Given I am on the homepage
    When I click on the Account function provided by the site on the homepage
    And I click on the Sign Up button on the opened page
    And I enter a password different from the previously entered password in the password confirmation field
    Then I should receive an error message confirming the password mismatch

  Scenario: Verify error message when entering a password with less than 6 characters
    Given I am on the homepage
    When I click on the Account function provided by the site on the homepage
    And I click on the Sign Up button on the opened page
    And I enter a password with less than six characters in the password field
    Then I should receive an error message indicating that the password should be at least six characters long

  Scenario: Verify that a new user can successfully register with valid information
    Given I am on the registration page
    When I enter valid registration details
    And I click on the Save button
    And I should see a confirmation message stating that my registration was successful

  Scenario: Verify that user can add products to the cart successfully
    Given I am on the product listing page
    When I select a product and size
    And I click on the Add to Cart button
    Then the product should be added to the cart
    And the total cart value should be updated with the product price

