Feature: Checkout

  Background:
    Given Open app

  Scenario: Registered user credit card checkout with having data for shipping and payment using search
    Given User login with credentials "roman.romanenko@grinteq.com" "Zaq12345!"
    When User click on search icon
    And User search "Jordan II"
    And User open details of item
    And User add item to card
    And User move to checkout
    And User click add payment detail button
    And User click on place order button
    Then User see order description
    And User log out

  Scenario: Registered user credit card checkout with having data for shipping and payment using catalog
    Given User login with credentials "roman.romanenko@grinteq.com" "Zaq12345!"
    When User open catalog
    And User switch to Art tab
    And User open details of item
    And User add item to card
    And User move to checkout
    And User click add payment detail button
    And User click on place order button
    Then User see order description
    And User log out

  Scenario: Checkout not register user with using search
    When User click on search icon
    And User search "Jordan"
    And User open details of item
    And User add item to card
    And User move to checkout
    And User continue checkout as a guest
    And User fill shipping address and email
    And User fill payment details
    And User click on place order button
    Then User see order description

  Scenario: Checkout not register user whit using catalog
    When User open catalog
    And User switch to Art tab
    And User open details of item
    And User add item to card
    And User move to checkout
    And User continue checkout as a guest
    And User fill shipping address and email
    And User fill payment details
    And User click on place order button
    Then User see order description
