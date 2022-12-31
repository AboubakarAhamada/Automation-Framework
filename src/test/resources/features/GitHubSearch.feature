@searchOnGitHub
Feature: Search on GitHub page
  Background: pre-request
    Given I open GitHub home page

  @test1
  Scenario: Search Selenium
    When I lookup the word "Selenium"
    Then search results display the word "Selenium"

  @test1
  Scenario: Search Cypress
    When I lookup the word "Cypress"
    Then search results display the word "Cypress"

  @test2
  Scenario Outline: "<keyword>"
    When I lookup the word "<keyword>"
    Then search results display the word "<keyword>"
    Examples:
    |keyword|
    |Java   |
    |Python |
    |Laravel|