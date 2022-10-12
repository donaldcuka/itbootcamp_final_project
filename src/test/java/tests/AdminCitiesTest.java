package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class AdminCitiesTest extends BaseTest{

    // Test #1: Visits the admin cities page and list cities

    @Test
    public void visitCitiesPage() {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        adminCitiesPage.cities();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]/span"));
        Assert.assertTrue(logoutBtn.isDisplayed());
    }


    // Test #2: Create new city

    @Test
    public void createNewCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.newItem();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));
        System.out.println(adminCitiesPage.getCity());
    }


    // Test #3: Edit city

    @Test
    public void editCity() throws InterruptedException {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.getEdit().click();
        adminCitiesPage.editCity();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        WebElement msgBox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        Assert.assertTrue(msgBox.getText().contains("Saved successfully"));
        System.out.println(adminCitiesPage.getEditedCity());
    }


    // Test #4: Search city

    @Test
    public void searchCity() {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();
        adminCitiesPage.cities();
        adminCitiesPage.search();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement expectedResult = driver.findElement(By.xpath(" //*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div/div[1]"));


        Assert.assertTrue(adminCitiesPage.getSearch().getText().contains(expectedResult.getText()));
    }

    // Test #5: Delete city

    @Test
    public void deleteCity() {
        homePage.login();
        loginPage.login();
        adminCitiesPage.adminClick();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        adminCitiesPage.cities();
        adminCitiesPage.getSearch().sendKeys(adminCitiesPage.getCity());
        String expectedResult = adminCitiesPage.getCity();
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));

        Assert.assertEquals(actualResult.getText(), expectedResult);

        WebElement deleteIcon = driver.findElement(By.xpath("//*[@id=\"delete\"]/span"));
        deleteIcon.click();

        WebElement delete = driver.findElement(By.xpath("//*[@id=\"app\"]/div[5]/div/div/div[2]/button[2]/span"));
        delete.click();
    }
}