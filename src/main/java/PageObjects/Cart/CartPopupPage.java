package PageObjects.Cart;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPopupPage extends BasePage {

    public CartPopupPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LoggerFactory.getLogger(CartPopupPage.class);

    @FindBy(css = "a.btn-primary")
    private WebElement goToCartBtn;

    @FindBy(css = ".modal-content .btn.btn-secondary")
    private WebElement continueShoppingBtn;

    @FindBy(css = "a.btn.btn-primary")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = ".modal-content .product-name")
    private WebElement productName;

    @FindBy(css = ".modal-content p.product-price")
    private WebElement productPrice;

    @FindBy(css = "span.product-quantity")
    private WebElement productQuantityLabel;

    @FindBy(css = ".modal-content p.cart-products-count")
    private WebElement productQuantitySummary;

    @FindBy(css = ".modal-content .value")
    private WebElement totalProductValue;

    public void continueShopping() {
        waitToBeClickable(continueShoppingBtn);
        click(continueShoppingBtn);
    }

    public void proceedToCheckout() {
        click(proceedToCheckoutBtn);
    }

    public String getProductName() {
        return productName.getText();
    }

    public double getProductPrice() {
        return getPrice(productPrice);
    }

    public double getTotalProductPrice() {
        return getPrice(totalProductValue);
    }

    public String getProductQuantityLabelText() {
        return productQuantityLabel.getText();
    }

    public int getQuantity() {
        waitToBeVisible(productQuantityLabel);
        return Integer.parseInt(productQuantityLabel.getText().replace("Quantity: ", ""));
    }

    public String getProductQuantitySummary() {
        return productQuantitySummary.getText();
    }

    public void printProductDetails() {
        logger.info("Product name is: " + getProductName());
        logger.info("Product price is: " + getProductPrice());
        logger.info("Product TOTAL price is: " + getTotalProductPrice());
        logger.info(getProductQuantityLabelText());
        logger.info("Quantity summary: " + getProductQuantitySummary());
    }
}
