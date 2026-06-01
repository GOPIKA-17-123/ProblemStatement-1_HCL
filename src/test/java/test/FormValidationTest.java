package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.RegistrationPage;

public class FormValidationTest extends BaseTest {
    @Test(priority = 1)
    public void verifyEmptyRegistrationValidation() {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.clickSignupLogin();
        rp.clickSignup();
        String msg = rp.getNameValidationMessage();
        Assert.assertFalse(msg.isEmpty());
    }
    @Test(priority = 2)
    public void verifyInvalidEmailValidation() {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.clickSignupLogin();
        rp.enterName("Gopika");
        rp.enterEmail("abc123");
        rp.clickSignup();
        String msg = rp.getEmailValidationMessage();
        Assert.assertFalse(msg.isEmpty());
    }
}