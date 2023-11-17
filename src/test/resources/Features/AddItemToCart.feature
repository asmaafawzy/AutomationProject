@Test
Feature: The User can add an item to the Cart  
  Scenario: Check that the user can add an item to the cart 
    Given the user opens the portal URL "<url>" 
    And  scrolls down to Hot deals sections
    And clicks to view all items in the Hot deals sections
    When clicks to view the details of any item
    And the user clicks to add the item to the cart 
    And opens the cart from the header 
    Then the item will be displayed with same price and same number of items added 

    Examples:
    |url|
    |https://momomarket.africa/Portal/|