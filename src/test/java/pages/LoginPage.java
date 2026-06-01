package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {
    WebDriver driver;
    By signupLoginBtn = By.xpath("//a[contains(text(),'Signup / Login')]");
    By email = By.xpath("//input[@data-qa='login-email']");
    By password = By.xpath("//input[@data-qa='login-password']");
    By loginBtn = By.xpath("//button[@data-qa='login-button']");
    By errorMessage = By.xpath("//p[contains(text(),'incorrect')]");
    By logoutBtn = By.xpath("//a[contains(text(),'Logout')]");
    By signupName = By.name("name");
    By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void clickSignupLogin() {
        waitForElement(signupLoginBtn);
        driver.findElement(signupLoginBtn).click();
    }
    public void login(String user, String pass) {
        waitForElement(email);
        driver.findElement(email).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
    public String getErrorMessage() {
        waitForElement(errorMessage);
        return driver.findElement(errorMessage).getText();
    }
    public boolean isLogoutDisplayed() {
        waitForElement(logoutBtn);
        return driver.findElement(logoutBtn).isDisplayed();
    }
    public void clickLogout() {
        driver.findElement(logoutBtn).click();
    }
    public void registerNewUser(String name, String emailId) {
        driver.findElement(signupName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(emailId);
        driver.findElement(signupBtn).click();
    }
}