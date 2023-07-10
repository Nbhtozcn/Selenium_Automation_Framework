Feature: En Uygun Feature
#  Scenario: Login
#    Given En uygun login
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

  Scenario: As an admin user I should not be able to select a seat which is already booked
    Given Navigated to home page
    And Click on bus tab
    When Fill out the form
    And Click on search button
    When Select the company
    And Choose the seat is already booked
    Then User should see the warning message

  Scenario: Validate navbar links functionality
    Given Navigated to home page
    And Click each of navigate bar link
    Then Verify that the page has loaded successfully by checking the page URL

  Scenario: Hepsi burada
    Given Go to hepsiburada
