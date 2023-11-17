@Test
Feature: The system has no broken links in the home page 

  Scenario: Check that there are no broken links in the home page 
    Given the user opens the home page URL "<url>" 
    When checking for broken links
    Then the system shall contain only valid links 
 Examples:
    |url|
    |https://momomarket.africa/Portal/|