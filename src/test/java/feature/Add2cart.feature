Feature: Cart functionality

  Scenario: Successfully adding a product to the cart
    Given I am on the Demoblaze homepage
    And I Select the the laptop category
    Then select click on any laptop related item
    And I click on the "Add to cart" button
    And I click on the "OK" button in the alert dialog
    Then I click on the cart icon
    And I should see my selected item in the cart