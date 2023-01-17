package modules;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.GitHubHomePage;
import page_objects.LoginPage;
import utils.BrowserFactory;

public class Hooks {
    //TODO: Configure test run before and after
    public static WebDriver driver;
    private static GitHubHomePage gitHubHomePage = new GitHubHomePage();
    private static LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void beforeAll(){
        driver = BrowserFactory.getFactoryDriver();
        PageFactory.initElements(driver, gitHubHomePage);
        PageFactory.initElements(driver, loginPage);


    }

    @AfterAll
    public  static void afterAll(){
        driver.quit();
    }
}
