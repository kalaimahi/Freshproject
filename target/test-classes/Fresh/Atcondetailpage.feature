
Feature: To verify detail page functionality
Background:
Given  User have to be in detail page
Scenario: To verify add to cart functionality from detail page
When User have to add asin to cart from detail page
Then Asin should present in cart
Scenario: To verify the variable shipping threshold in detail page
When VST should present in buybox
Then VST value should match the expected value
Scenario: To add more than one asin in detail page
When Add three quantities to cart
Then Asin should be added to cart
 

