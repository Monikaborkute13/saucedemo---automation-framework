package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.DashboardPage;

public class LogoutTest extends BaseClass {

	@Test
	public void logoutTest() {

	    System.out.println("Step 1: Starting Login");

	    LoginPage lp = new LoginPage(driver);
	    lp.login("standard_user", "secret_sauce");

	    // ✅ Verify login success first
	    Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
	            "Login failed, cannot proceed");

	    System.out.println("Step 2: Login Done");

	    DashboardPage dp = new DashboardPage(driver);

	    System.out.println("Step 3: Clicking Logout");
	    dp.logout();

	    System.out.println("Step 4: Logout Clicked");

	    // ✅ Final validation
	    Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"),
	            "Logout Failed!");
	}
}