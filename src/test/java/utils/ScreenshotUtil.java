package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String name) {

        String path = System.getProperty("user.dir") + "/screenshots/" + name + ".png";

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved: " + path);

        } catch (IOException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }

        return path;
    }

	public static String capture(WebDriver driver, String name) {
		// TODO Auto-generated method stub
		return null;
	}
}