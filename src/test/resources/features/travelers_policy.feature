Feature: Travelers Policy
  The company follows a policy of adding and removing travelers, depending on the traveler type
  and on the trip type

  Scenario: Economy trip, usual traveler
    Given there is an economy trip
    When we have a usual traveler
    Then you can add and remove him from an economy trip

  Scenario: Economy trip, VIP traveler
    Given there is an economy trip
    When we have a VIP traveler
    Then you can add him but cannot remove him from an economy trip

  Scenario: Business trip, usual traveler
    Given there is an business trip
    When we have a usual traveler
    Then you cannot add or remove him from a business trip

  Scenario: Business trip, VIP traveler
    Given there is an business trip
    When we have a VIP traveler
    Then you can add him but cannot remove him from a business trip