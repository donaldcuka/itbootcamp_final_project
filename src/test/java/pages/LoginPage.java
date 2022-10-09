package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    protected By email = By.id("email");
    protected By password = By.id("password");
    protected By loginBtn = By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");

    protected Faker faker = new Faker();


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public WebElement getEmail() {
        return getDriver().findElement(email);
    }


    public WebElement getPassword() {
        return getDriver().findElement(password);
    }


    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }


    public Faker getFaker() {
        return faker;
    }


    public void login(){
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys("12345");
        getLoginBtn().click();
    }


    public void fakerLogin(){
        String email = faker.internet().emailAddress();
        String pass = faker.internet().password();
        getEmail().click();
        getEmail().sendKeys(email);
        getPassword().click();
        getPassword().sendKeys(pass);
        getLoginBtn().click();
    }


    public void wrongPass(String password){
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys(password);
        getLoginBtn().click();

    }


    public String getAttribute(){
        return  getEmail().getAttribute("type");
    }
}