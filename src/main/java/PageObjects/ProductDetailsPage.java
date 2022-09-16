package PageObjects;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.math.BigDecimal;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(tagName = "h1")
    private WebElement productTitle;

    @FindBy(className = "current-price")
    private WebElement productPrice;

    public void addToCart() {
        click(addToCartBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blockcart-modal"))); // wrzuc to do base page
    }

    public void setQuantity(int quantity) {
        quantityInput.clear();
        sendKeys(quantityInput, String.valueOf(quantity));
    }

    public String getProductName() {
        return productTitle.getText();
    }

    //BigDecimal -> przechowywanie cen w javie
    public BigDecimal getProductPrice() {
        String price = productPrice.getText();
        String priceWithoutCurrency = price.replace("$", "");
        return new BigDecimal(priceWithoutCurrency);
    }
}

