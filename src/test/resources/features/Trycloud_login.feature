Feature:Logging into Trycloud app
  As a user, I should be able to login.

  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials


    When user use username "<username>" and password "<password>"
    And user click login button
    Then user should be at dashboard page
    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |


  Scenario: User login with wrong credentials

    When user provide username "BLA" and password "BLA"
    Then we should still be at login page
    And login error message should be present

