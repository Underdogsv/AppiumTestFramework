Feature: Web View functionality verification (registration and Login)

#  Commented till reCaptcha be resolved
  @disabled
  Scenario: Trying login with incorrect credentials functionality
    Given Start application
    And Click login button
    And Scroll Menu List down
    Then Select "Web View" menu item on main screen
    And Click login button on the News page
    And Enter new username and password to the Login form
    And Click login button on Login form
    And Resolve Captcha
    And Click login button on Login form
    Then Verify that error message is displayed

@disabled
  Scenario: New user registration functionality
    Given Start application
    And Click login button
    And Scroll Menu List down
    Then Select "Web View" menu item on main screen
    And Click login button on the News page
    And  Click Create Account button on Registration Screen
    And Enter new username and password to the Registration screen
    Then Click Create Account button on Registration Screen
    And Resolve Captcha
    Then Click Create Account button on Registration Screen
    Then Verify that the My Profile section displayed on the News page
    And Click logout button on the News page
    And Click login button on the News page
    And Enter existed username and password to the Login form
    And Click login button on Login form
    And Resolve Captcha
    And Click login button on the News page
    Then Verify that the My Profile section displayed on the News page

  @disabled
  Scenario Outline: Login and Logout functionality
    Given Start application
    And Click login button
    And Scroll Menu List down
    Then Select "Web View" menu item on main screen
    And Click login button on the News page
    And Enter "<username>" to username and "<password>" to password fields on the login screen
    And Click login button on Login form
    And Resolve Captcha
    And Click login button on Login form
    Then Verify that the My Profile section displayed on the News page

    Examples:
      | username     | password  |
      | SomeTestUser | 123454321 |