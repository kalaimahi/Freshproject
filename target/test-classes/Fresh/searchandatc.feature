Feature: To verify the add to cart functionality in search result page
Scenario: User have to search for an item and add to cart
Given User have to search an item and in search result page
When User have to add an item to cart
Then Cart should be updated and its count should be one

