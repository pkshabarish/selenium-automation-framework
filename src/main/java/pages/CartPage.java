package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By checkoutBtn = By.id("checkout");
    By firstNameField = By.id("first-name");

    public void checkout() {

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));

        WebElement checkout = driver.findElement(checkoutBtn);

        try {
            checkout.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkout);
        }

        wait.until(ExpectedConditions.urlContains("checkout-step-one")); // 🔥 correct URL
    }
}