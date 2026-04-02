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

        WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));

        // 🔥 Try normal click
        checkout.click();
        System.out.println("Tried normal checkout click");

        // 🔥 If still on cart page → use JS click
        if (!driver.getCurrentUrl().contains("checkout")) {

            System.out.println("Normal checkout click failed → using JS click");

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkout);
        }

        // 🔥 FINAL WAIT
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("checkout"),
            ExpectedConditions.visibilityOfElementLocated(firstNameField)
        ));

        System.out.println("Checkout page loaded");
    }
}