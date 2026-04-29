Feature: Update User API

@smoke @regression @api @update
Scenario: Update User
  Given API base URI is set
  When I update user
  Then API response should be valid