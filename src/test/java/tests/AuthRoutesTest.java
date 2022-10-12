package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTest extends BaseTest{

    // Test #1: Forbids visits to home url if not authenticated

    @Test
    public void forbidsVisitToHomeUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        String expected = "/login";

        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }


    // Test #2: Forbids visits to profile url if not authenticated

    @Test
    public void forbidsVisitToProfileUrl(){
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        String expected = "/login";

        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }


    // Test #3: Forbids visits to admin cities url if not authenticated

    @Test
    public void forbidsVisitToAdminCities() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        String expected = "/login";

        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }


    // Test #4: Forbids visits to admin users url if not authenticated

    @Test
    public void forbidsVisitToAdminUsers(){
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        String expected = "/login";

        String actual = driver.getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));
    }
}