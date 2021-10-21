Feature: make access to Files module
  As a user, I should be able to access to Files module.

  Background:
    Given user on the login page

  Scenario Outline: Verify user can access to Files module

    When  user use username "<username>" and password "<password>"
    When user clicks on Files module
    Then verify the page title is "Files - Trycloud"



    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |

  Scenario Outline: Verify user can select all the uploaded files from page

    When  user use username "<username>" and password "<password>"
    When user clicks on Files module
    And  click the top left checkbox of the table
    Then verify all the files are selected

    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |