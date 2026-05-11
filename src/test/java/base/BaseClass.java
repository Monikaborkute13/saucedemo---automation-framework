package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void setup() {

	    ChromeOptions options = new ChromeOptions();

	    // 🔴 Disable password manager completely
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false); // ⭐ IMPORTANT

	    options.setExperimentalOption("prefs", prefs);

	    // 🔴 Disable automation & security popups
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-infobars");
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("--disable-blink-features=AutomationControlled");

	    // 🔴 Run in clean mode (VERY IMPORTANT)
	    options.addArguments("--incognito");

	    driver = new ChromeDriver(options);

	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    driver.get("https://www.saucedemo.com/");

	    System.out.println("Application Launched Successfully");
	}

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}