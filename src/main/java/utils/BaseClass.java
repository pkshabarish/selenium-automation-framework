package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
    public static WebDriver driver;

    public void setup() {

    	String env = System.getProperty("env");

    	ChromeOptions options = new ChromeOptions();

    	if ("ci".equals(env)) {
    	    options.addArguments("--headless");
    	    options.addArguments("--no-sandbox");
    	    options.addArguments("--disable-dev-shm-usage");
    	}

    	driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    public void tearDown() {
        driver.quit();
    }
}
