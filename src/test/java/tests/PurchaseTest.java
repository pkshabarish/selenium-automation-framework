package tests;

import org.testng.annotations.*;
import pages.*;
import utils.BaseClass;

public class PurchaseTest extends BaseClass {

    LoginPage login;
    HomePage home;
    CartPage cart;

    @BeforeMethod
    public void start() {
        setup();
        login = new LoginPage(driver);
        home = new HomePage(driver);
        cart = new CartPage(driver);
    }

    @Test
    public void testPurchaseFlow() {

        login.login("standard_user", "secret_sauce");  // 🔥 MUST

        home.addItemToCart();

        home.goToCart();

        cart.checkout();
    }

    @AfterMethod
    public void end() {
        tearDown();
    }
}