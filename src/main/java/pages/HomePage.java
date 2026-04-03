package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public void addItemToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        driver.findElement(addToCart).click();

 

        System.out.println("Item added to cart");
    }

    public void goToCart() {

        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartIcon));

        // 🔥 Try normal click first
        cart.click();
        System.out.println("Tried normal click");

        // 🔥 HARD CHECK → if still not navigated, use JS click
        if (!driver.getCurrentUrl().contains("cart")) {

            System.out.println("Normal click failed → using JS click");

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cart);
        }

        // 🔥 FINAL WAIT
        wait.until(ExpectedConditions.urlContains("cart"));

        System.out.println("Cart page loaded");
    }
}