package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    By menuBtn = By.id("react-burger-menu-btn");
    By logoutBtn = By.id("logout_sidebar_link");
    By inventoryText = By.className("title");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(inventoryText).isDisplayed();
    }

    public void logout() {
        driver.findElement(menuBtn).click();
        driver.findElement(logoutBtn).click();
    }
}