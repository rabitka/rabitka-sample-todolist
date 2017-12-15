Feature: Edit Todo Item

  Scenario: Remove one Item
    Given The Todo list contains not completed Todo Item "Buy cheese"
    When I replace title of Todo Item "Buy cheese" by "Buy french cheese"
    Then Todo list contains only Todo Item "Buy french cheese" marked as not completed

  Scenario: Remove all completed Items
    Given The Todo list contains completed Todo Item "Buy cheese"
    Given The Todo list contains not completed Todo Item "Walk the dog"
    When I remove all completed Items
    Then Todo list contains only Todo Item "Walk the dog"
