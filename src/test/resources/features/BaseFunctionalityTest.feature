Feature: Base verification of the functionality like drag and drop, long press, double click and etc

  Scenario: Double click functionality
    Given Start application
    And Click login button
    Then Select "Double Tap" menu item on main screen
    And Perform double tap on the button
    Then Verify that the pop up message about success is displayed

  Scenario: Drag and Drop functionality
    Given Start application
    And Click login button
    Then Select "Drag & Drop" menu item on main screen
    And Perform drag element to the drop zone
    Then Verify that the Circle dropped text is displayed

  Scenario: Long press functionality
    Given Start application
    And Click login button
    Then Select "Long Press" menu item on main screen
    And Perform long press on the button
    Then Verify that the you pressed me hard :P text is displayed

  Scenario: Horizontal swipe functionality
    Given Start application
    And Click login button
    And Scroll Menu List down
    Then Select "Carousel" menu item on main screen
    And Perform swipe on the left direction and check that correct element displayed
    Then Perform swipe on the right direction and check that correct element displayed

  Scenario: Wheel Picker functionality
    Given Start application
    And Click login button
    And Scroll Menu List down
    Then Select "Wheel Picker" menu item on main screen
    And Select blue color in dropdown on Wheel Picker screen
    Then Verify that headline contains blue color on Wheel Picker screen
    And Select red color in dropdown on Wheel Picker screen
    Then Verify that headline contains red color on Wheel Picker screen
    And Select green color in dropdown on Wheel Picker screen
    Then Verify that headline contains green color on Wheel Picker screen
    And Select green color in dropdown on Wheel Picker screen
    Then Verify that headline contains green color on Wheel Picker screen
    And Select black color in dropdown on Wheel Picker screen
    Then Verify that headline contains black color on Wheel Picker screen

#  Scenario Outline: Wheel Picker functionality
#    Given Start application
#    And Click login button
#    And Scroll Menu List down
#    Then Select "Wheel Picker" menu item on main screen
#    And Select <color> color in dropdown on Wheel Picker screen
#    Then Verify that headline contains <color> color on Wheel Picker screen
##
#    Examples:
#      | color |
#      | blue  |
#      | red   |
#      | green |
#      | black |
