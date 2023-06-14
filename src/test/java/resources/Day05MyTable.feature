Feature: US02


  Scenario Outline:TC01: Verify the emails in the MyTable table
    Given Connection to the database
    Then  List the "email" data in the MyTable
    And   Verify the "<email>" in the MyTable
    Then  Close the connection to the database
    Examples:
      | email               |
      | ahmet@example.com   |
      | ayse@example.com    |
      | mehmet@example.com  |
      | elif@example.com    |
      | cemal@example.com   |
      | fatma@example.com   |
      | ali@example.com     |
      | zeynep@example.com  |
      | mustafa@example.com |
      | sevgi@example.com   |


  Scenario Outline: TC02: Verify the name of columns in the MyTable table
    Given Connection to the database
    Then  List the "myTable" tables columns name
    And   Verify the "<myTable>" in the MyTable table
    Then  Close the connection to the database
    Examples:
      | myTable |
      | id      |
      | name    |
      | age     |
      | email   |
      | address |