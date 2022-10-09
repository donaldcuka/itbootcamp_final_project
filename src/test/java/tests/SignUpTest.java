package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTest extends BaseTest{


    // Test #1: Visits the signup page

    @Test
    public void signupPage(){
        homePage.signup();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/signup"));
    }


    // Test #2: Checks input types
    @Test
    public void inputTypes() {
        homePage.signup();
        String typeEmail = "email";
        String actTypeEmail = signUpPage.getEmail().getAttribute("type");
        Assert.assertTrue(actTypeEmail.equals(typeEmail));

        String typePass = "password";
        String actTypePass = signUpPage.getPassword().getAttribute("type");
        Assert.assertTrue(actTypePass.equals(typePass));

        String typeConfirm = "password";
        String actTypeConfirm = signUpPage.getConfirm().getAttribute("type");
        Assert.assertTrue(actTypeConfirm.equals(typeConfirm));
    }


    // Test #3: Displays errors when user already exists

    @Test
    public void displayErrors() {
        homePage.signup();
        signUpPage.signUp("Test Test", "admin@admin.com", "wr000ng", "wr000ng");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement closeBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]"));
        String expected = "E-mail already exists";
        Assert.assertTrue(closeBtn.getText().contains(expected));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("/signup"));
    }


    // Test #4: Signup

    @Test
    public void signUpTest() {
        homePage.signup();
        signUpPage.signUp("Niko Belic", "testmail@mail.com", "444444", "444444");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement importantPopUp = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]"));

        Assert.assertEquals(importantPopUp.getText(), "IMPORTANT: Verify your account");

        WebElement closeButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button/span"));
        closeButton.click();
    }


}