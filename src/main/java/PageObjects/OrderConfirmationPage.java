package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderConfirmationPage extends BasePage {

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LoggerFactory.getLogger(OrderConfirmationPage.class);

    @FindBy(css = "div.col-sm-4.col-xs-9.details span")
    private WebElement productName;

    @FindBy(css = "div.col-sm-6.col-xs-12.qty div div:nth-child(2)")
    private WebElement quantity;

    @FindBy(css = "div.col-sm-6.col-xs-12.qty div div:nth-child(1)")
    private WebElement price;

    @FindBy(css = "div.col-sm-6.col-xs-12.qty div div:nth-child(3)")
    private WebElement total;

    @FindBy(css = " tr:nth-child(2) td:nth-child(2)")
    private WebElement shippingAndHandlingLabel;

    @FindBy(css = "#order-details ul li:nth-child(2)")
    private WebElement paymentMethod;

    @FindBy(css = "#order-details ul li:nth-child(3)")
    private WebElement shippingMethod;

    @FindBy(css = "#content-hook_payment_return ul")
    private WebElement checkPaymentDetails;

    @FindBy(css = "#order-details li:nth-child(1)")
    private WebElement orderReference;

    public String getProductName() {
        return productName.getText();
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getText());
    }

    public double getUnitPrice() {
        return getPrice(price);
    }

    public double getTotalPrice() {
        return getPrice(total);
    }

    public String getShippingAndHandling() {
        return shippingAndHandlingLabel.getText();
    }

    public String getPaymentMethod() {
        return paymentMethod.getText();
    }

    public String getShippingMethod() {
        return shippingMethod.getText();
    }

    public String getCheckPaymentDetails() {
        return checkPaymentDetails.getText();
    }

    public String getOrderReferenceNumber() {
        return orderReference.getText().replace("Order reference: ", "");
    }

    public void getOrderDetails() {
        getQuantity();
        getUnitPrice();
        getTotalPrice();
        getShippingAndHandling();
        getPaymentMethod();
        getShippingMethod();
        getCheckPaymentDetails();
        getOrderReferenceNumber();
        logger.info(getQuantity() + ", " + getUnitPrice() + ", " + getTotalPrice() + ", " + getShippingAndHandling()
                    + ", " + getPaymentMethod() + ", " + getShippingMethod() + ", " + getCheckPaymentDetails()
                    + ", " + getOrderReferenceNumber());
    }
}
