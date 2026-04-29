Feature: Negative API Test

@smoke @regression @api @negative
Scenario: Invalid Endpoint
  Given API base URI is set
  When I call invalid endpoint
  Then API should return error