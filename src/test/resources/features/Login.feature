Feature: Login feature

  Scenario: Login Success
    Given I open Login Page
    When I enter email "elliott.nance@testpro.io"
    And I enter password "te$t$tudent"
    And I submit
    Then I am logged in
