package utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}