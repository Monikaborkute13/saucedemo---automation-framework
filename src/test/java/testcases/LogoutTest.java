package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;

public class LogoutTest extends BaseClass {

    @Test
    public void logoutTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login(config.getUsername(), config.getPassword());

        DashboardPage dp = new DashboardPage(driver);
        dp.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"),
                "Logout Failed!");
    }
}