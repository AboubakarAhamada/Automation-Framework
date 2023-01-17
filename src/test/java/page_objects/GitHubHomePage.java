package page_objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GitHubHomePage {
    //TODO: store all Google page objects/web elements

    @FindBy(name = "q")
    private static WebElement searchBar;
    @FindBy(className = "HeaderMenu-link--sign-in")
    private static WebElement signInLink;

    public static void searchFor(String keyword){
        searchBar.click();
        searchBar.sendKeys(keyword);
        searchBar.sendKeys(Keys.ENTER);
    }

    public static void openLoginPage(){
        signInLink.click();
    }
}
