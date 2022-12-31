package modules;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.GitHubSearchPage;
import utils.BrowserFactory;

public class Hooks {
    //TODO: Configure test run before and after
    public static WebDriver driver;
    GitHubSearchPage gitHubSearchPage = new GitHubSearchPage();

    @Before
    public void setUp(){
        driver = BrowserFactory.getFactoryDriver();
        PageFactory.initElements(driver, gitHubSearchPage);
    }

    @After
    public  void tearDown(){
        driver.quit();
    }
}
