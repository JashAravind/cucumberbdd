Feature: Add to cart

  @demo
  Scenario Outline: Add maximum priced dress from store - one quantity
    Given I'm on the Store Page
    When I click on "<category>" from top menu
    And I add "<priceCategory>" price dress item to cart
    And I click on "proccedtoCheckout" on shopping cart
    Then Max price should be visible in cart
    Examples:
      | category |priceCategory|
      | Dresses   |Maximum|