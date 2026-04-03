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

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon));

        WebElement cart = driver.findElement(cartIcon);

        try {
            cart.click();
            System.out.println("Clicked cart normally");
        } catch (Exception e) {
            System.out.println("Using JS click");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cart);
        }

        wait.until(ExpectedConditions.urlContains("cart.html")); // 🔥 must
    }
}