package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page_objects.GitHubHomePage;
import page_objects.LoginPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static modules.Hooks.driver;


public class LoginStepDefinition {
    @Given("I am on the github home page")
    public void iAmOnTheGithubHomePage() {
        driver.get("http://www.github.com");
    }

    @When("I click the Sign In link")
    public void iClickTheSignInLink() {
        driver.findElement(By.
                xpath("/html/body/div[1]/div[1]/header/div/div[2]/div/div/div[2]/a")).click();
    }

    @Then("I access to the login page")
    public void iAccessToTheLoginPage() {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.className("btn")));
        String currentTitle = driver.getTitle();
        String loginTitle = "Sign in to GitHub";
        String currentUrl = driver.getCurrentUrl();
        String loginUrl = "https://github.com/login";

        Assert.assertEquals(currentUrl, loginUrl);
        Assert.assertTrue(currentTitle.contains(loginTitle));
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://github.com/login");
    }

    @When("I enter {string} as username and {string} as password")
    public void iEnterAsUsernameAndAsPassword(String username, String password) {
        LoginPage.enterLoginAndPassword(username, password);
    }

    @And("I hit the log in button")
    public void iHitTheLogInButton() {

        LoginPage.clickLoginButton();
    }

    @Then("I connexion failed")
    public void iConnexionFailed() {
        String currentUrl = driver.getCurrentUrl();
        String loginFailedUrl = "https://github.com/session";

        Assert.assertEquals(currentUrl, loginFailedUrl);
    }

    @And("I can see an error message {string}")
    public void iCanSeeAnErrorMessage(String errorMessage) {
        WebElement errorContent = LoginPage.getErrorContent();
        String color = errorContent.getCssValue("color");

        Assert.assertEquals(color, "rgba(36, 41, 47, 1)");
        Assert.assertEquals(errorMessage, errorContent.getText());
    }
}
