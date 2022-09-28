package PageObjects;

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

    @FindBy(css = ".modal-content .product-name")
    private WebElement productName;

    @FindBy(css = ".modal-content p.product-price")
    private WebElement productPrice;

    @FindBy(css = ".modal-content span.product-quantity")
    private WebElement productQuantityLabel;

    @FindBy(css = ".modal-content p.cart-products-count")
    private WebElement productQuantitySummary;

    @FindBy(css = ".modal-content .value")
    private WebElement totalProductValue;

    public void goToCart() {
        click(goToCartBtn);
    }

    public void continueShopping() {
        click(continueShoppingBtn);
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

    public String getProductQuantity() {
        return productQuantityLabel.getText();
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

        String quantity = getProductQuantity();
        logger.info("Quantity is: " + quantity);

        String summary = getProductQuantitySummary();
        logger.info("Quantity summary: " + summary);
    }
}
