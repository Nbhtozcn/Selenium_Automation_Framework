Feature: This feature includes Favorites related test cases
  Scenario: TC_03 Add a Book to Favorites
    Given The user is on the homepage
    And The user select English as language
    And I am logged in to my account
    When I search for a book using its title
    And I find a book that I want to add to my favorites
    When I click on the "Add to Favorites" button for that book
    And I should see a confirmation message indicating that the book has been added successfully
    Then the book should be added to my list of favorite books

  Scenario: TC_04 Remove a Book from Favorites
    Given The user is on the homepage
    And The user select English as language
    And I am logged in to my account
    Then I click on My Account button
    When I click on My Favorites button
    And I click on the Remove button for that book
    Then the book should be removed from my list of favorite books
