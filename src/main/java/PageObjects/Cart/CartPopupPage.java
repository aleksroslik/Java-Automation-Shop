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

    /*@FindBy(css = ".modal-content span.product-quantity")
    private WebElement quantityOfProduct;*/

    public void goToCart() {
        click(goToCartBtn);
    }

    public void continueShopping() {
        //scheduleWait(500);
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

    public void getProductDetails() {
        String product = getProductName();
        logger.info("Product name is: " + product);

        double price = getProductPrice();
        logger.info("Product price is: " + price);

        double totalSum = getTotalProductPrice();
        logger.info("Product TOTAL price is: " + totalSum);

        String quantity = getProductQuantityLabelText();
        logger.info(quantity);

        String summary = getProductQuantitySummary();
        logger.info("Quantity summary: " + summary);
    }
}
