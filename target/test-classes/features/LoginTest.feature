Feature: Login functionality check


  Scenario: Login functionality
    Given Start application
    And Enter "" to username and "" to password fields on the login screen
    And Click login button
    Then Verify that the Please enter Username or password message is displayed on Login page
    And Enter "admin" to username and "" to password fields on the login screen
    And Click login button
    Then Verify that the Please enter Username or password message is displayed on Login page
    And Enter "" to username and "admin" to password fields on the login screen
    And Click login button
    Then Verify that the Please enter Username or password message is displayed on Login page
    And Enter "admin" to username and "12345" to password fields on the login screen
    And Click login button
    Then Verify that the Invalid Credentials message is displayed on Login page
    And Enter "admin" to username and "admin" to password fields on the login screen
    And Click login button
    Then Verify that the title is displayed on main screen

  Scenario: Login screen content
    Given Start application
    And Verify that the LOG IN field contains correct label on Login page
    And Verify that the username field contains correct label on Login page
    And Verify that the password field contains correct label on Login page
