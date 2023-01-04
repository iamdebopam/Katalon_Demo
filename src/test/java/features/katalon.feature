Feature: Login
  Scenario: Verify Successful Login with Valid credentials
    Given Initialize the driver
    And user navigates to page
    And click on make appointment
    When enters credentials username "John Doe" and password "ThisIsNotAPassword"
    And click on Login
    Then Verify if the account is logged in successfully with valid credentials
    And close the browser

  Scenario Outline: Verify Login with Invalid credentials
    Given Initialize the driver
    And user navigates to page
    And click on make appointment
    When enters invalid credentials username "<sheetName>" and password <rowNumber>
    And click on Login
    Then Verify if the account is logged in successfully with invalid credentials
    And close the browser

    Examples:
    |sheetName|rowNumber|
    |Debopam|1|

  Scenario: Book an appointment successfully
    Given Initialize the driver
    And user navigates to page
    And click on make appointment
    When enters credentials username "John Doe" and password "ThisIsNotAPassword"
    And click on Login
    When User chooses a facility for the appointment
    And User chooses a healthcare program
    And User provides a date for the appointment
    And User clicks the book appointment button
    Then Appointment gets booked successfully
    And Booking information matches with confirmation information
    And close the browser
