Feature: DB Test
@SanityTest
Scenario: I want to verify that the user is created in MySQL 
Given Database is connected
When I run the query         
Then I should see the user created
Then I should see the customer account deleted
Then I should see the customer details updated