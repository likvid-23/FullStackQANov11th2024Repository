Feature: Create Employee Functionality

  Scenario Outline: Validate create Employee Functionality
    Given I provide Post Employee <Request> End Point
    And I create RequestSpecification object
    And I provide the Request header
    And I provide the Request Body
    When I run the POST http Method
    Then I get the status code as 201
    And  I store the employee ID variable
    Given I provide Get Employee <Request> Endpoint
    And I create RequestSpecification object
    And I provide the Request header
    When I run the GET http Method
    Then I get the status code as 200
    Given I provide Delete Employee <Request> Endpoint
    And I create RequestSpecification object
    And I provide the Request header
    When I run the DELETE http Method
    Then I get the status code as 200



    Examples:
      | Request                                             |
      | http://localhost:9090/sgtesting/api/v1/employees    |
      | http://localhost:9090/sgtesting/api/v1/employees/20 |
      | http://localhost:9090/sgtesting/api/v1/employees/11 |