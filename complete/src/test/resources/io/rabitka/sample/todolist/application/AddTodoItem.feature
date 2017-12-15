Feature: Add Todo Item

  Scenario: Add one Todo Item
    Given an empty Todo list
    When I add a Todo Item "Buy cheese"
    Then Todo list contains only one Todo Item "Buy cheese" marked as not completed

  Scenario: Add invalid Todo Item
    Given an empty Todo list
    When I add an empty Todo Item
    Then An error is thrown
    And todo list is empty


