@Test
Feature: The system has no broken links in the Hot Deals page 

  Scenario: Check that there are no broken links in the Hot Deals page 
    Given the user opens the hot deals page URL "<url>" 
    When checking for broken links in hot deals page
    Then the system shall contain only valid links in hot deals page
 Examples:
    |url|
    |https://momomarket.africa/Portal/|