Feature: 10.Story: As a user, I should be able to access to Files module.
  AC #1 - verify users can change the app Settings.
  AC #2- verify users see the app storage usage

  Background:
    Given user on the login page
  @vit3
  Scenario Outline: verify users can change the app Settings


    When user use username "<username>" and password "<password>"
    And user click login button
    When Click Settings on the left bottom corner
    Then Verify user can click any buttons.

    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user34   | Userpass123 |
      | user99   | Userpass123 |









#10.Story: As a user, I should be able to access to Files module.
#AC #1 - verify users can change the app Settings.
#1. Login as a user
#2. Click Settings on the left bottom corner
#3. Verify user can click any buttons.
#AC #2- verify users see the app storage usage
#1. Login as a user
#2. Check the current storage usage
#3. Upload a file
#4. Refresh the page
#5. Verify the storage usage is increased