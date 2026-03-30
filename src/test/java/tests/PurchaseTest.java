package tests;


import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ExtentManager;
import utils.ScreenshotUtil;   // ✅ ADD THIS IMPORT

public class PurchaseTest extends BaseClass {

    LoginPage login;
    HomePage home;
    CartPage cart;

    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void start() {
        setup();
        extent = ExtentManager.getReport();
        test = extent.createTest("Purchase Test");

        login = new LoginPage(driver);
        home = new HomePage(driver);
        cart = new CartPage(driver);
    }

    @Test
    public void testPurchaseFlow() {

        System.out.println("Step 1: Starting test");

        login.login("standard_user", "secret_sauce");
        System.out.println("Step 2: Logged in");

        home.addItemToCart();
        System.out.println("Step 3: Item added");

        home.goToCart();
        System.out.println("Step 4: Navigated to cart");

        System.out.println("Step 5: Before checkout");
        cart.checkout();
        System.out.println("Step 6: After checkout");
    }

    @AfterMethod
    public void end(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Failed");
            ScreenshotUtil.capture(driver, result.getName());
        }
        extent.flush();
        tearDown();
    }
}