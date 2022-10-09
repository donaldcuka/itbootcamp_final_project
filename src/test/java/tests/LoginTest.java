package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {


    // Test #1: Visits the login page

    @Test
    public void visitTheLoginPage() {
        homePage.login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/login"));
    }


    // Test #2: Checks input types

    @Test
    public void checksInputTypes() {
        homePage.login();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String expectedEmailField = "email";
        String actualEmailField = loginPage.getEmail().getAttribute("type");
        Assert.assertTrue(actualEmailField.equals(expectedEmailField));

        String expctedPasswordField = "password";
        String actualPasswordField = loginPage.getPassword().getAttribute("type");
        Assert.assertTrue(actualPasswordField.equals(expctedPasswordField));
    }


    // Test #3: Displays errors when user does not exist

    @Test
    public void displaysErrors(){
        homePage.login();
        loginPage.fakerLogin();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement redAlert = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div"));
        String expected = "User does not exists";
        Assert.assertTrue(redAlert.getText().contains(expected));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("login"));
    }


    //  Test #4: Displays errors when password is wrong

    @Test
    public void wrongPassword() {
        homePage.login();
        loginPage.wrongPass("wR0nG");
        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]"));
        String expected = "Wrong password";
        Assert.assertTrue(closeBtn.getText().contains(expected));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("login"));
    }


    // Test #5: Login

    @Test
    public void login() {
        homePage.login();
        loginPage.login();
        String websiteUrl = "https://vue-demo.daniel-avellaneda.com/home";
        Assert.assertTrue(websiteUrl.contains("/home"));
    }


    // Test #6: Logout

    @Test
    public void logout() {
        homePage.login();
        loginPage.login();
        Assert.assertTrue(homePage.getLogoutBtn().isDisplayed());
        homePage.logout();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("login"));
        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }


}