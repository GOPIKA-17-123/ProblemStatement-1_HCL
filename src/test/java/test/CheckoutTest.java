package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import base.BaseTest;
import pages.CheckoutPage;
import pages.LoginPage;

public class CheckoutTest
        extends BaseTest {
    @Test(priority = 1)

    public void verifyCheckoutWithoutLogin(){
        CheckoutPage cp = new CheckoutPage(driver);
        cp.clickProducts();
        cp.addProductToCart();
        cp.clickViewCart();
        cp.proceedToCheckout();
        Assert.assertTrue(cp.isRedirectedToLogin());
    }
    @Test(priority = 2)
    public void verifyCompleteCheckout(){
        ConfigReader cr = new ConfigReader();
        LoginPage lp = new LoginPage(driver);

        CheckoutPage cp =
                new CheckoutPage(driver);

        lp.clickSignupLogin();

        lp.login(
                cr.getEmail(),
                cr.getPassword());

        cp.clickProducts();

        cp.addProductToCart();

        cp.clickViewCart();

        cp.proceedToCheckout();

        cp.placeOrder();

        cp.enterPaymentDetails();

        cp.clickPayButton();

        Assert.assertTrue(
                cp.isOrderPlaced());
    }



}