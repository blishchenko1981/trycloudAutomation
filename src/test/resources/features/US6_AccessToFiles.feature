Feature: As a user, I should be able to access to Files module

  Background:
    Given user on the login page

        Scenario Outline: Login with valid credentials

    When user use username "<username>" and password "<password>"
    And user click login button
    Then user goes to "Files" module and clicks the "+" icon on top
    And user clicks "New Folder", writes a folder name and clicks submit icon
    Then user should see the folder displayed on the page

    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |


            #AC #1- verify users can create a folder
       #1. Login as a user
      #2. Click the “+” icon on top
      #3. Click “New Folder
      #4. Write a folder name
      #5. Click submit icon
      #6. Verify the folder is displayed on the page



  Scenario Outline: Login with valid credentials

    When user use username "<username>" and password "<password>"
    And user click login button
    Then user goes to "Files" module and is choosing a folder from the page
    And user clicks the "+" icon on top
    And user clicks upload file and upload the file
    Then user should see the file is displayed on the page


    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user37   | Userpass123 |
      | user67   | Userpass123 |
      | user97   | Userpass123 |


#AC #2 - verify users can upload a file inside a folder
#1. Login as a user
#2. Choose a folder from the page
#3. Click the “+” icon on top
#4. Click “upload file”
#5. Upload a file
#6. Verify the file is displayed on the page
#(Pre-condition: there should be at least 1 folder is created on the filers page)
