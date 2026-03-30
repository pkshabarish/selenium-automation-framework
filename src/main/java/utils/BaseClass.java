package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    public static WebDriver driver;

    public void setup() {

        ChromeOptions options = new ChromeOptions();

        String isCI = System.getenv("CI");

        if ("true".equalsIgnoreCase(isCI)) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com/");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}