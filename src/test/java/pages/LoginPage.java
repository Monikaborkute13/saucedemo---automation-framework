package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators (SauceDemo correct)
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

    // ✅ MAIN METHOD (used in all test cases)
    public void login(String uname, String pwd) {
        enterUsername(uname);
        enterPassword(pwd);
        clickLogin();
    }

    // Validations
    public boolean isUsernameDisplayed() {
        return driver.findElement(username).isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        return driver.findElement(password).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginBtn).isDisplayed();
    }

    // Safe method (no exception)
    public boolean isErrorDisplayed() {
        return driver.findElements(errorMsg).size() > 0;
    }
}