package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class NavigationTest extends BaseClass {

    @Test
    public void verifyNavigation() {

        LoginPage lp = new LoginPage(driver);
        lp.login(config.getUsername(), config.getPassword());

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Navigation Failed");
    }
}