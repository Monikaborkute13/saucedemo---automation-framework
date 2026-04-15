package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.*;

public class CheckoutTest extends BaseClass {

    @Test(description="TS_002_TC_CO_002 - Verify checkout with valid details")
    public void verifyCheckout() {

        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce"); // ✅ TEMP FIX (if config not ready)

        ProductsPage pp = new ProductsPage(driver);
        pp.addProductToCart();
        pp.goToCart();

        CartPage cp = new CartPage(driver);
        cp.clickCheckout();

        CheckoutPage ch = new CheckoutPage(driver);
        ch.enterDetails("John", "Doe", "12345");
        ch.completeCheckout();
        
        try {
            driver.switchTo().alert().accept();
            System.out.println("Popup handled");
        } catch (Exception e) {
            System.out.println("No popup present");
        }

        Assert.assertTrue(ch.isOrderPlaced(), "Checkout Failed");
    }
}