Feature: Delete User API

@smoke @regression @api @delete
Scenario: Delete User
  Given API base URI is set
  When I delete a user
  Then API response should be valid