package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;
import utilities.ConfigReader;
public class LoginTest extends BaseTest {
    ConfigReader config = new ConfigReader();
    @DataProvider(name="loginData")
    public Object[][] getData() {
        return new Object[][] {
                {
                        config.getValidEmail(),
                        config.getValidPassword()
                },
                {
                        config.getValidEmail(),
                        config.getInvalidPassword()
                }
        };
    }
    @Test(priority=1)
    public void verifySuccessfulLogin() {
        LoginPage lp = new LoginPage(driver);
        lp.clickSignupLogin();
        lp.login(config.getValidEmail(), config.getValidPassword());
        Assert.assertTrue(lp.isLogoutDisplayed());
    }
    @Test(priority=2)
    public void verifyLoginFailure() {
        LoginPage lp = new LoginPage(driver);
        lp.clickSignupLogin();
        lp.login(config.getValidEmail(), config.getInvalidPassword());
        String actualError = lp.getErrorMessage();
        Assert.assertTrue(actualError.contains("incorrect"));
    }
    @Test(priority=3)
    public void verifyLogout() {
        LoginPage lp = new LoginPage(driver);
        lp.clickSignupLogin();
        lp.login(config.getValidEmail(), config.getValidPassword());
        lp.clickLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }
    @Test(priority=4)
    public void verifyRegistration() {
        LoginPage lp = new LoginPage(driver);
        lp.clickSignupLogin();
        String uniqueEmail = "user" + System.currentTimeMillis() + "@gmail.com";
        lp.registerNewUser("TestUser", uniqueEmail);
        Assert.assertTrue(driver.getCurrentUrl().contains("signup"));
    }
}