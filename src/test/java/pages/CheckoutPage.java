package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage
        extends BasePage {

    WebDriver driver;

    // LOCATORS

    By productsBtn =
            By.xpath("//a[contains(text(),'Products')]");

    By firstAddToCartBtn =
            By.xpath("(//a[contains(text(),'Add to cart')])[1]");

    By viewCartBtn =
            By.xpath("//u[contains(text(),'View Cart')]");

    By proceedToCheckoutBtn =
            By.xpath("//a[contains(text(),'Proceed To Checkout')]");

    By placeOrderBtn =
            By.xpath("//a[contains(text(),'Place Order')]");

    By nameOnCard =
            By.name("name_on_card");

    By cardNumber =
            By.name("card_number");

    By cvc =
            By.name("cvc");

    By expiryMonth =
            By.name("expiry_month");

    By expiryYear =
            By.name("expiry_year");

    By payBtn =
            By.id("submit");

    By orderSuccessText =
            By.xpath("//b[contains(text(),'Order Placed!')]");

    By registerLoginBtn =
            By.xpath("//u[contains(text(),'Register / Login')]");

    // CONSTRUCTOR

    public CheckoutPage(WebDriver driver){

        super(driver);

        this.driver = driver;
    }

    // METHODS

    public void clickProducts(){

        waitForElement(productsBtn);

        scrollToElement(productsBtn);

        clickUsingJS(productsBtn);
    }

    public void addProductToCart(){

        waitForElement(firstAddToCartBtn);

        scrollToElement(firstAddToCartBtn);

        clickUsingJS(firstAddToCartBtn);
    }

    public void clickViewCart(){

        waitForElement(viewCartBtn);

        clickUsingJS(viewCartBtn);
    }

    public void proceedToCheckout(){

        waitForElement(
                proceedToCheckoutBtn);

        scrollToElement(
                proceedToCheckoutBtn);

        clickUsingJS(
                proceedToCheckoutBtn);
    }

    public void placeOrder(){

        waitForElement(placeOrderBtn);

        clickUsingJS(placeOrderBtn);
    }

    public void enterPaymentDetails(){

        waitForElement(nameOnCard);

        driver.findElement(nameOnCard)
                .sendKeys("Gopika");

        driver.findElement(cardNumber)
                .sendKeys("1234123412341234");

        driver.findElement(cvc)
                .sendKeys("123");

        driver.findElement(expiryMonth)
                .sendKeys("12");

        driver.findElement(expiryYear)
                .sendKeys("2030");
    }

    public void clickPayButton(){

        scrollToElement(payBtn);

        clickUsingJS(payBtn);
    }

    public boolean isOrderPlaced(){

        waitForElement(orderSuccessText);

        return driver
                .findElement(orderSuccessText)
                .isDisplayed();
    }

    public boolean isRedirectedToLogin(){

        waitForElement(registerLoginBtn);

        return driver
                .findElement(registerLoginBtn)
                .isDisplayed();
    }
}