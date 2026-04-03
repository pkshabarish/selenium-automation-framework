package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");

    public void login(String user, String pass) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();

        // 🔥 VERY IMPORTANT WAIT
        wait.until(ExpectedConditions.urlContains("inventory"));

        System.out.println("Login successful");
    }
}