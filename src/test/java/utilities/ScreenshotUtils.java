package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void captureScreenshot(WebDriver driver, String testName) {

        try {
            // 📁 Create screenshots folder if not exists
            File directory = new File("screenshots");
            if (!directory.exists()) {
                directory.mkdir();
            }

            // 📸 Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 🕒 Add timestamp to avoid duplicate file error
            String fileName = testName + "_" + System.currentTimeMillis() + ".png";

            // 📌 Destination file
            File dest = new File("screenshots/" + fileName);

            // 📂 Copy file
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}