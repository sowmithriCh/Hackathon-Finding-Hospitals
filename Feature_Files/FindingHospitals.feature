Feature: Finding Hospitals

  @smoke
  Scenario Outline: Getting doctor details
    Given the user navigates to home page
    When user Searches Dentists in Bangalore
    When user applied filters
    Then user gets the top five doctor details

  @smoke
  Scenario Outline: Getting all Surgeries
    Given the user navigates to Surgeries page
    When user scrolls down to surgeries
    When user gets the list of surgeries
    Then user gets to top of the page

  @regression
  Scenario Outline: Validating demo with invalid details
    Given the user navigates to Health and Wellness  page
    When user enters incorrect details
    Then user tries to click the demo button

  @regression
  Scenario Outline: Validating demo with valid details
    When user user enters correct details
    Then user validates the Thank you message