package testcases;

import org.testng.annotations.Test;
import base.BaseClass;

public class PerformanceTest extends BaseClass {

    @Test
    public void pageLoadTimeTest() {

        long start = System.currentTimeMillis();
        driver.get(config.getUrl());
        long end = System.currentTimeMillis();

        System.out.println("Page Load Time: " + (end - start) + " ms");
    }
}