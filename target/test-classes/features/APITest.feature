Feature: API Test

@smoke @regression @smoke @regression
Scenario: Update User API
  Given API base URI is set
  When I update user
  Then API response should be valid