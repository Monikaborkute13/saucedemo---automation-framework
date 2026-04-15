package pages;

import org.openqa.selenium.*;

public class CheckoutPage {

    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String fn, String ln, String zip) {
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void completeCheckout() {
        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();
    }

    public boolean isOrderPlaced() {
        return driver.findElement(successMsg).isDisplayed();
    }
}