package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_objects.GitHubSearchPage;

import static modules.Hooks.driver;

public class GitHubSearchStepDefinition {
    @Given("I open GitHub home page")
    public void iOpenGitHubHomePage() {
        driver.get("http://www.github.com");
    }

    @When("I lookup the word {string}")
    public void iLookupTheWord(String arg0) {
    GitHubSearchPage.searchFor(arg0);
    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String arg0) {
        Assert.assertTrue(driver.getTitle().contains(arg0));
    }
}
