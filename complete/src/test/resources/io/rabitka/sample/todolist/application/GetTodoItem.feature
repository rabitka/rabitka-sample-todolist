Feature: Get Todo Item

  Scenario: Get all
    Given The Todo list contains completed Todo Item "Buy cheese"
    Given The Todo list contains not completed Todo Item "Walk the dog"
    When I get all Items
    Then I obtains Todo Items "Buy cheese" & "Walk the dog"

  Scenario: Get all completed Items
    Given The Todo list contains completed Todo Item "Buy cheese"
    Given The Todo list contains not completed Todo Item "Walk the dog"
    When I get all completed Items
    Then I obtains only Todo Item "Buy cheese"


  Scenario: Get all not completed Items
    Given The Todo list contains completed Todo Item "Buy cheese"
    Given The Todo list contains not completed Todo Item "Walk the dog"
    When I get all not completed Items
    Then I obtains only Todo Item "Walk the dog"
