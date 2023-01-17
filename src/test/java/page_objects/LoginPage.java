package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "login_field")
    private static WebElement loginField;
    @FindBy(id = "password")
    private static WebElement passwordField;
    @FindBy(name = "commit")
    private static WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"js-flash-container\"]/div")
    private static WebElement errorContent;

    public static void enterLoginAndPassword(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public static void clickLoginButton(){
        loginButton.click();
    }

    public static WebElement getErrorContent(){
        return errorContent;
    }
}
