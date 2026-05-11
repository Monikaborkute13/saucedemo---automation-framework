package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.xpath("//h3[@data-test='error']");

    // Actions
    public void enterUsername(String uname) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String uname, String pwd) {
        enterUsername(uname);
        enterPassword(pwd);
        clickLogin();
    }

    // Validations - Display
    public boolean isUsernameDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(username)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordDisplayed() {
        return driver.findElement(password).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginBtn).isDisplayed();
    }

    // Validations - Enabled
    public boolean isUsernameEnabled() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(username)).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPasswordEnabled() {
        return driver.findElement(password).isEnabled();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginBtn).isEnabled();
    }

    // Validation - Clickable (Explicit Wait)
    public boolean isLoginButtonClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Error message validation (safe method)
    public boolean isErrorDisplayed() {
        return driver.findElements(errorMsg).size() > 0;
    }
}