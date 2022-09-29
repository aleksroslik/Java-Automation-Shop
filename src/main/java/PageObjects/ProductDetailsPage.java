package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(tagName = "h1")
    private WebElement productTitle;

    @FindBy(className = "current-price")
    private WebElement productPrice;

    @FindBy(css = ".add [type='submit']")
    private WebElement addToCartBtn;

    @FindBy(className = ".modal-content")
    private WebElement modalContent;

    public void addToCart() {
        click(addToCartBtn);
        scheduleWait(1000);
    }

    public ProductDetailsPage setQuantity(int quantity) {
        quantityInput.clear();
        sendKeys(quantityInput, String.valueOf(quantity));
        return this;
    }

    public String getProductName() {
        return productTitle.getText();
    }

    public double getProductPrice() {
        return getPrice(productPrice);
    }
}
