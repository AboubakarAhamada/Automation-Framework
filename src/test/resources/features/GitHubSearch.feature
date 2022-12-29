Feature: Search on GitHub page
  Scenario: Basic search
    Given I open GitHub home page
    When I lookup the word "Selenium"
    Then search results display the word "Selenium"