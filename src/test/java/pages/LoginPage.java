package pages;

// https://vue-demo.daniel-avellaneda.com/login

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private WebElement usernameField = getDriver().findElement(By.name("email"));
    private WebElement passwordField = getDriver().findElement(By.name("password"));
    private WebElement loginButton = getDriver().findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button"));

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public WebElement getUsernameField() {
        return usernameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void login(String username, String password){
        usernameField.clear();
        passwordField.clear();

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        loginButton.click();
    }
}
