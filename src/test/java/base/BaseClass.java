package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

// ✅ Import this
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public WebDriver driver;
    public ConfigReader config;

    @BeforeMethod
    public void setUp() {
    	//// ✅ Step 1: Chrome Options
    	ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        // Initialize Config
        config = new ConfigReader();

        // ✅ SETUP DRIVER FIRST
        WebDriverManager.chromedriver().setup();

        // Launch Browser
        driver = new ChromeDriver();

        // Maximize
        driver.manage().window().maximize();

        // Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open URL
        driver.get(config.getUrl());

        System.out.println("Application Launched Successfully");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser Closed");
    }
}