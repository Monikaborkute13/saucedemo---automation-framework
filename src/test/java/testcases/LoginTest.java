package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

    // TS_001 - Verify Login Functionality

    @Test(priority = 1, description = "TS_001_TC_LT_001 - Verify login page is displayed")
    public void verifyLoginPageDisplayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("saucedemo"), "Login page not displayed");
    }

    @Test(priority = 2, description = "TS_001_TC_LT_002 - Verify username field is displayed")
    public void verifyUsernameField() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isUsernameDisplayed(), "Username field not visible");
    }

    @Test(priority = 3, description = "TS_001_TC_LT_003 - Verify password field is displayed")
    public void verifyPasswordField() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isPasswordDisplayed(), "Password field not visible");
    }

    @Test(priority = 4, description = "TS_001_TC_LT_004 - Verify login button is displayed")
    public void verifyLoginButton() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isLoginButtonDisplayed(), "Login button not visible");
    }

    @Test(priority = 5, description = "TS_001_TC_LT_005 - Verify login with valid credentials")
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Login failed with valid credentials");
    }

    @Test(priority = 6, description = "TS_001_TC_LT_006 - Verify login with invalid username")
    public void invalidUsernameTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong_user", "secret_sauce");

        Assert.assertTrue(lp.isErrorDisplayed(), "Error not displayed");
    }

    @Test(priority = 7, description = "TS_001_TC_LT_007 - Verify login with invalid password")
    public void invalidPasswordTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "wrong_pass");

        Assert.assertTrue(lp.isErrorDisplayed(), "Error not displayed");
    }

    @Test(priority = 8, description = "TS_001_TC_LT_008 - Verify login with both invalid credentials")
    public void invalidCredentialsTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong", "wrong");

        Assert.assertTrue(lp.isErrorDisplayed(), "Error not displayed");
    }

    // 🔽 NEW UI VALIDATION TESTS

    @Test(priority = 9, description = "TS_001_TC_LT_009 - Verify username field is enabled")
    public void verifyUsernameEnabled() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isUsernameEnabled(), "Username field not enabled");
    }

    @Test(priority = 10, description = "TS_001_TC_LT_010 - Verify password field is enabled")
    public void verifyPasswordEnabled() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isPasswordEnabled(), "Password field not enabled");
    }

    @Test(priority = 11, description = "TS_001_TC_LT_011 - Verify login button is enabled")
    public void verifyLoginButtonEnabled() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isLoginButtonEnabled(), "Login button not enabled");
    }

    @Test(priority = 12, description = "TS_001_TC_LT_012 - Verify login button is clickable")
    public void verifyLoginButtonClickable() {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.isLoginButtonClickable(), "Login button not clickable");
    }
}