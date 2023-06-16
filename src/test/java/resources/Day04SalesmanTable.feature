Feature: US01:

  @Db
  Scenario Outline: TC01: Verify the salesman_id in the Salesman table
    Given Connection to the database
    Then  List the "salesman_id" in the salesman_id column
    And   Verify the <salesman_id>
    Then  Close the connection to the database
    Examples:
      | salesman_id |
      | 12387       |
      | 123654      |
      | 123963      |
      | 123741      |
      | 123852      |
      | 123159      |
      | 123981      |
      | 12387       |
      | 123654      |
      | 123963      |
      | 123741      |
      | 123852      |
      | 123159      |
      | 123981      |
      | 128541      |
      | 129874      |
      | 121234      |
      | 120281      |
      | 120481      |

  @Db
  Scenario Outline: TC02: Verify the firstname in the Salesman table
    Given Connection to the database
    Then  List the "firstname" in the salesman table
    And   Verify the "<firstname>"
    Then  Close the connection to the database
    Examples:
      | firstname |
      | Ali       |
      | Veli      |
      | Kemal     |
      | Hulya     |
      | Ayse      |
      | Kiraz     |
      | Mutlu     |
      | Ali       |
      | Veli      |
      | Kemal     |
      | Hulya     |
      | Ayse      |
      | Kiraz     |
      | Mutlu     |
      | Hasan     |
      | Ahmet     |
      | Sevim     |
      | Selma     |
      | Derya     |

  Scenario Outline: TC03: Verify the city in the Salesman table
    Given Connection to the database
    Then  List the "city" data
    And   Verify "<city>"
    Then  Close the connection to the database
    Examples:
      | city     |
      | Istanbul |
      | Rize     |
      | Samsun   |
      | Ordu     |
      | Amasya   |
      | Aydin    |
      | Izmir    |
      | Istanbul |
      | Rize     |
      | Samsun   |
      | Ordu     |
      | Amasya   |
      | Aydin    |
      | Izmir    |
      | Van      |
      | Erbil    |
      | Siirt    |
      | Malatya  |
      | Giresun  |

  Scenario Outline: TC04: Verify the earning of the Salesman table
    Given Connection to the database
    Then  List the "earning" data in the salesman
    And   Verify <earning>
    Then  Close the connection to the database
    Examples:
      | earning |
      | 1200    |
      | 2000    |
      | 3000    |
      | 5000    |
      | 4000    |
      | 1000    |
      | 3600    |
      | 1200    |
      | 2000    |
      | 3000    |
      | 5000    |
      | 4000    |
      | 1000    |
      | 3600    |
      | 4500    |
      | 3845    |
      | 9854    |
      | 9654    |
      | 1235    |


  Scenario Outline: TC05: Verify the company_name of the Salesman table
    Given Connection to the database
    Then  List the "company_name"
    And   Verify "<company_name>" in the salesman table
    Then  Close the connection to the database
    Examples:
      | company_name |
      | Honda        |
      | Toyota       |
      | Honda        |
      | Ford         |
      | Hyundai      |
      | Ford         |
      | Honda        |
      | Honda        |
      | Toyota       |
      | Honda        |
      | Ford         |
      | Hyundai      |
      | Ford         |
      | Honda        |
      | Mercedes     |
      | BMW          |
      | Renault      |
      | Mercedes     |
      | Tofas        |





