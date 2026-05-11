package pages;

import org.openqa.selenium.*;

public class ProductsPage {

    WebDriver driver;

    By firstProductAddBtn = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(firstProductAddBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}