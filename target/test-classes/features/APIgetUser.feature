Feature: Get User API

@smoke @regression @api @get
Scenario: Get User
  Given API base URI is set
  When I get user details
  Then API response should be valid