package testcases;

import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;

public class EdgeCaseTest extends BaseClass {

    @Test
    public void emptyLoginTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("", "");

        System.out.println("Handled empty input");
    }
}