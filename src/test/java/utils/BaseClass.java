package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class BaseClass {

    public static WebDriver driver;

    public void setup() {

        ChromeOptions options = new ChromeOptions();
      
        options.addArguments("--headless=new");   // 🔥 important
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    public void tearDown() {
        driver.quit();
    }
}