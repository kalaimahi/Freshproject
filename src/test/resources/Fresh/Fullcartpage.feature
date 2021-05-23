Feature: To verify the full cart page functionalities
Background:
Given User have to be in full cart page

Scenario: To verify the incrementing functionality in full cart page
When User have to increment the quantity to three in quantity selector
Then Cart should be updated to three

Scenario: To verify the decrement functionality in full cart page
When User have to decrement the quantity to one in full cart page
Then Cart count should be updated 
@Sanity
Scenario: To verify the delete functionality in full cart page
When User have to delete the asin
Then Asin should be deleted from cart




