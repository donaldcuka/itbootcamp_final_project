package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LocaleTest extends BaseTest{


    // Test #1: Set locale to ES

    @Test
    public void espanaLanguage() {
        homePage.getLanguage().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement espana = driver.findElement(By.xpath("//*[@id=\"list-item-75\"]/div"));
        espana.click();

        String expectedResult = "Página de aterrizaje";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));

        Assert.assertEquals(expectedResult, actualResult.getText());
    }


    // Test #2: Set locale to EN

    @Test
    public void englishLanguage(){
        homePage.getLanguage().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement english = driver.findElement(By.xpath("//*[@id=\"list-item-73\"]/div"));
        english.click();

        String expectedResult = "Landing";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));

        Assert.assertEquals(expectedResult, actualResult.getText());
    }


    // Test #3: Set locale to FR

    @Test
    public void frenchLanguage(){
        homePage.getLanguage().click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement french = driver.findElement(By.xpath("//*[@id=\"list-item-77\"]/div"));
        french.click();

        String expectedResult = "Page d'atterrissage";
        WebElement actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1"));

        Assert.assertEquals(expectedResult, actualResult.getText());
    }

}