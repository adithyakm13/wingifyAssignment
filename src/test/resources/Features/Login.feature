Feature: Feature to test the login functionality
  Scenario: validate successful login when both valid username and valid password is entered
    Given browser is open
    And user is on login page
    When user enters username and password
    And clicks login
    Then user should be logged in

  Scenario: validate whether error message is displayed when user tries to login using only username without password
    Given browser is open
    And user is on login page
    When user enters only username
    And clicks login
    Then error message "Password must be present" should be displayed

  Scenario: validate whether error message is displayed when user tries to login using only password without username
    Given browser is open
    And user is on login page
    When user enters only password
    And clicks login
    Then error message2 "Username must be present" should be displayed

  Scenario: validate whether error message is displayed when user tries to login using only password without username
    Given browser is open
    And user is on login page
    When user enters only nothing
    And clicks login
    Then error message3 "Both Username and Password must be present" should be displayed

  Scenario: validate the sorting using amount after loggin to the account
    Given browser is open
    And user is logged in
    When amount is clicked it is sorted

  Scenario: validate the social media login functionality
    Scenario Outline: check the login using twitter facebook and linkedin
      Given browser is open
      And user is on login page
      When user clicks on <socialmedia>
      Then user should be taken to <socialmedia> page
      Examples:
        | socialmedia |
        | twitter     |
        | facebook    |
        | linkedin    |