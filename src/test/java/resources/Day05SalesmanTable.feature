Feature: US03

  Scenario Outline: TC01: Verify the name of columns in the Salesman table
    Given Connection to the database
    Then  List the "salesman" table columns
    And   Verify the "<columnNames>" in the Salesman table
    Then  Close the connection to the database
    Examples:
      | columnNames  |
      | salesman_id  |
      | firstname    |
      | city         |
      | earning      |
      | company_name |


  Scenario Outline: TC02: Verify the sum of salaries in the Salesman table
    Given Connection to the database
    And   Verify the sum of "earning" in the "salesman" table is <sumOfEarning>
    Then  Close the connection to the database
    Examples:
      | sumOfEarning |
      | 68688        |


  Scenario Outline: TC03: Verify the sum of salaries in the Salesman table
    Given Connection to the database
    And   Retrieve the sum of "earning" in the "salesman" table
    Then  Verify the is <sumOfEarning> in the salesman table
    Then  Close the connection to the database
    Examples:
      | sumOfEarning |
      | 68688        |