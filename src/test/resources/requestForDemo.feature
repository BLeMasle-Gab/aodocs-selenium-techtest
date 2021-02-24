Feature: requestForDemo

  Scenario Outline: RequestDemoWithError
    Given I Go to the url "http://www.google.fr" on the browser "<browser>"
    Then I search "AODOCS" on Google
    And I click on the link "www.aodocs.com" on result page
    Given I am on home page
    Then I click on the button Request a demo on the home page
    Given I am on request a demo page
    When I set the first name "Le Masle", the last name "" and the email "boutheina.lemasle@gmail.com" for the company "" size "5-50 employees" in the country "France" on the request demo page
    Then I verify that the error message "Please complete this required field." is displayed on the field "LastName"
    And I verify that the error message "Please complete this required field." is displayed on the field "Company"
    And I verify that the error message "Please complete this required field." is displayed on the field "Message"
    And I close the browser

    Examples: 
      | dataName | browser |
      | chrome   | CHROME  |
      | firefox  | FIREFOX |
