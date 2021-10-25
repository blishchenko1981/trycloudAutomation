@vit @smoke
Feature: access to search any item
  14.Story: As a user, I should be able to access search any item/ users from the homepage.

  Background:
    Given user on the login page

  Scenario Outline: Check ability to access search function


    When user use username "<username>" and password "<password>"
    And user click login button
    When Click magnifier icon on the right top
    When Search any existing file or folder or user name
      | name of file | Selenium_methods.pdf |
    Then Verify the app displays the expected result option


    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |

