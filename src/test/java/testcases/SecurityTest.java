package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class SecurityTest extends BaseClass {

    @Test
    public void invalidLoginTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("wrong_user", "wrong_pass");

        Assert.assertTrue(driver.getPageSource().contains("Epic sadface"),
                "Security validation failed");
    }
}