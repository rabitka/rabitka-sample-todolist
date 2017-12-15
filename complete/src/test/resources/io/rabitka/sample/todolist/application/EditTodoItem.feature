Feature: Edit Todo Item

  Scenario: Edit title
    Given The Todo list contains only not completed Todo Item "Buy cheese"
    When I replace title of Todo Item "Buy cheese" by "Buy french cheese"
    Then Todo list contains only Todo Item "Buy french cheese" marked as not completed

  Scenario: Mark as completed
    Given The Todo list contains not completed Todo Item "Buy cheese"
    Given The Todo list contains not completed Todo Item "Walk the dog"
    When I mark Todo Item "Buy cheese" as completed
    Then Todo list contains Todo Item "Buy cheese" marked as completed
    And Todo list contains Todo Item "Walk the dog" marked as not completed

  Scenario: Mark as not completed
    Given The Todo list contains completed Todo Item "Buy cheese"
    Given The Todo list contains completed Todo Item "Walk the dog"
    When I mark Todo Item "Buy cheese" as completed
    Then Todo Item "Buy cheese" is marked as completed
    And Todo Item "Walk the dog" is marked as not completed
