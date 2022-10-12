package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTest extends BaseTest{

    @Test
    private void editProfile() throws InterruptedException {

        homePage.login();
        loginPage.login();
        profilePage.getMyProfile().click();
        profilePage.nameChange(profilePage.getRandomName());
        profilePage.phoneChange(profilePage.getRandomPhone());
        profilePage.cityChange();
        profilePage.countryChange(profilePage.getRandomCountry());
        profilePage.twitterChange(profilePage.getRandomTwitter());
        profilePage.gitHubChange(profilePage.getRandomGit());
        profilePage.getSave().click();


        String actualResult = profilePage.getMsgBox().getText();
        Assert.assertTrue(actualResult.contains("Profile saved successfuly"));


        String expctedName = profilePage.getRandomName();
        String actualName = profilePage.getName().getAttribute("value");
        Assert.assertEquals(actualName, expctedName);


        String expctedPhone = profilePage.getRandomPhone();
        String actualPhone = profilePage.getPhone().getAttribute("value");
        Assert.assertEquals(actualPhone, expctedPhone);


        String expctedCountry = profilePage.getRandomCountry();
        String actualCountry = profilePage.getCountry().getAttribute("value");
        Assert.assertEquals(actualCountry, expctedCountry);


        String expctedTwitter = profilePage.getRandomTwitter();
        String actualTwitter = profilePage.getTwitter().getAttribute("value");
        Assert.assertEquals(actualTwitter, expctedTwitter);


        String expctedGit = profilePage.getRandomGit();
        String actualGit = profilePage.getGitHub().getAttribute("value");
        Assert.assertEquals(actualGit, expctedGit);
    }

}