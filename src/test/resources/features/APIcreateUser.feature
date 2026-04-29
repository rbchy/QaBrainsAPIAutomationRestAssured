Feature: Create User API

@smoke @regression @api @create
Scenario: Create User
  Given API base URI is set
  When I create a user
  Then API response should be valid