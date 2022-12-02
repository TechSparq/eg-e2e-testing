Feature: Registration

  Background:
    Given Open app

  Scenario: Registration new user
    Given User switch to registration form
    When User fill the data for registration and confirm
    Then User see PTS
    And User open profile menu
    And User move to profile
    And User open Save Addresses tab
    And User click on add new button
    And User fill address data and save
    Then User validate that added address is display
    And User move to Saved Payments
    And User click on add new button
    And User fill payment data and save
    Then User validate that added payment method is display





