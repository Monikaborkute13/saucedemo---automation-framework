package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import base.BaseClass;

public class UITest extends BaseClass {

    @Test
    public void verifyUIElements() {

        Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
        System.out.println("UI Test is Passed: User name is Displaying");
        Assert.assertTrue(driver.findElement(By.id("user-name")).isEnabled());
        System.out.println("UI Test is Passed: User name is Enable");
     
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
        System.out.println("UI Test is Passed: user Password  is Displaying");
        Assert.assertTrue(driver.findElement(By.id("password")).isEnabled());
        System.out.println("UI Test is Passed: user Password is Enabled");
        
        
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
        System.out.println("UI Test is Passed: Login Button  is Displaying");
        Assert.assertTrue(driver.findElement(By.id("login-button")).isEnabled());
        System.out.println("UI Test is Passed: Login Button is Enabled");
 
    }
}