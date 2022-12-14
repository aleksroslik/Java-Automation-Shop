package PageObjects.Order;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BasePage {

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#order-history tr td:nth-child(1)")
    private WebElement date;

    @FindBy(css = "tr.text-xs-right.line-total td:nth-child(2)")
    private WebElement total;

    @FindBy(css = "td:nth-child(2) span")
    private WebElement payment;

    @FindBy(css = "#delivery-address address")
    private WebElement deliveryAddress;

    @FindBy(css = "#invoice-address address")
    private WebElement invoiceAddress;

    public String getOrderDate() {
        return date.getText();
    }

    public double getTotalPrice() {
        return getPrice(total);
    }

    public String getPaymentStatus() {
        return payment.getText();
    }

    public String getDeliveryAddress() {
        return deliveryAddress.getText();
    }

    public String getInvoiceAddress() {
        return invoiceAddress.getText();
    }
}
