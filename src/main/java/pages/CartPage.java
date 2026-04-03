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

        try {
            driver.findElement(checkoutBtn).click();
            System.out.println("Tried normal checkout click");
        } catch (Exception e) {
            System.out.println("Normal checkout failed → using JS click");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(checkoutBtn));
        }

        // 🔥 IMPORTANT WAIT
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("checkout-step-one"),
            ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))
        ));

        System.out.println("Checkout page loaded");
    }
}