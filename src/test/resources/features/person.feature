Feature: Person API
  As a user
  I want to be able to create, read, update, and delete persons
  So that I can manage a list of persons

  Scenario: Create a new person
    Given I have a new person with name "Adama" and email "adama@gmail.com"
    When I POST the person to the "api/person" endpoint
    Then the response status code should be 200
    And the response body should contain the person with name "Adama" and email "adama@gmail.com"

  Scenario: Get all persons
    Given there are persons with names "Adama", "Baba", and "Awa" in the database
    When I GET the "api/persons" endpoint
    Then the list response status code should be 200
    And the response body should contain a list of 3 persons with names "Adama", "Baba", and "Awa"

  Scenario: Update an existing person
    Given there is a person with name "Adama" and email "adama@gmail.com" in the database
    When I PUT the person with name "Adama" and email "adamaABC@gmail.com" to the "api/persons/{id}" endpoint
    Then the response status code should be 200
    And the response body should contain the person with name "Adama" and email "adamaABC@gmail.com"