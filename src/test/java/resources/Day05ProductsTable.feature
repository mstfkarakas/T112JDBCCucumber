Feature: US04:


  Scenario Outline: TC01: Verify the sum of prices in the Products table
    Given Connection to the database
    And   Bring the sum of price from "price" column in the "products" table
    Then  Verify the expected price that is <sumOfPrice> in the products table
    Then  Close the connection to the database
    Examples:
      | sumOfPrice |
      | 10249      |