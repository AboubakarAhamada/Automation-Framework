
Feature: Login on user home page
  As github user I want to login on my account in order to access my home page

  Scenario: Open Login page
    Given I am on the github home page
    When I click the Sign In link
    Then I access to the login page
  @LoginTest
  Scenario Outline: Login with false credentials
    Given I am on the login page
    When I enter "<username>" as username and "<password>" as password
    And I hit the log in button
    Then I connexion failed
    And I can see an error message "Incorrect username or password."
    Examples:
      | username | password |
      |ALICE| ALICE123|
      |      alice@gmail.com    |1234          |


