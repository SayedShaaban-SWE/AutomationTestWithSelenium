Feature: Login and add some orders to the cart
  Background: set language to be english
    Given I select english from languages list

  @not-registered-email
  Scenario: Verify that user cannot log in with valid but not registered email
    When I click on sign in button at the top right corner
    Then I should navigated to the Sign in screen
    When I enter valid email but not registered like "sayedshaaban82@gmail.com"
    And I click on continue button
    Then I should see error message as "We cannot find an account with that email address"


  @add-item
  Scenario: Verify that Items are added to cart correctly
    When I click on All tab icon
    And I select "Today's Deals"
    Then I should be navigated to "Today's Deals" page
    When I click on 2nd category from categories list
    And I click on 1st product in this category
    And I click on 2nd item in this product
    And I add it to cart with Qty = 2
    And I do all the necessary actions to add the item to the cart
    And I go to the cart
    Then I should see items are added to the cart with details name, price, qty and subtotal is correct


  Scenario: Verify that you cannot see Your Orders and Your Addresses pages if you are not logged in. But you can see Your Lists intro screen
    When I click on “Hello, sign in Account & Lists” at the top right corner
    And I select “Your orders”
    Then I should navigated to the Sign in screen
    When I click on back arrow
    And I click on “Hello, sign in Account & Lists” at the top right corner
    And I select “Your Addresses”
    Then I should navigated to the Sign in screen
    When I click on back arrow
    And I click on “Hello, sign in Account & Lists” at the top right corner
    And I select “Your Lists”
    Then I should navigated to lists page
