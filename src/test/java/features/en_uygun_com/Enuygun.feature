Feature: En Uygun Feature
  Scenario: Login
    Given En uygun login
  Scenario: As an admin user I should be able to book a bus ticket
    Given Navigated to home page
    And Click on bus tab
    When Fill out the form
    And Click on search button
    And Select the proper option
    And Choose the seat as male
    When Fill out the passenger information
    And Click on continue
    Then User should land on the payment page
