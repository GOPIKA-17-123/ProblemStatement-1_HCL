package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    By signupLogin = By.xpath("//a[contains(text(),'Signup / Login')]");
    By name = By.name("name");
    By email = By.xpath("//input[@data-qa='signup-email']");

    By signupBtn = By.xpath("//button[contains(text(),'Signup')]");
    public void clickSignupLogin() {
        click(signupLogin);
    }
    public void enterName(String userName) {
        type(name, userName);
    }
    public void enterEmail(String userEmail) {
        type(email, userEmail);
    }
    public void clickSignup() {
        click(signupBtn);
    }
    public String getNameValidationMessage() {
        return driver.findElement(name).getAttribute("validationMessage");
    }
    public String getEmailValidationMessage() {
        return driver.findElement(email).getAttribute("validationMessage");
    }
}