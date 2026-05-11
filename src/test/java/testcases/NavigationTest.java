package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;


public class NavigationTest extends BaseClass {

	@Test
	public void verifyNavigation() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login("standard_user", "secret_sauce");

	    // ✅ Add wait (IMPORTANT)
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("inventory"));

	    Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
	            "Navigation Failed");
	}
	}