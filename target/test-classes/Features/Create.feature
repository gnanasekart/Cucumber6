Feature: Login into CRM site
This feature to verify the login feature

#login using data driven without example
Scenario: Logining in with valid credential details
Given navigating to login page
When User enter username "demosalesmanager" and password "crmsfa"
And click the login button
Then Webpage should login successfully
And User verify crmsfa enter button
Then Click Create Lead link
And Enter user details to create lead
And Finally verify logout button