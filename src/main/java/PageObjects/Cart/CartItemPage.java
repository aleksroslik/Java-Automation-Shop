package PageObjects.Cart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class CartItemPage {

    public CartItemPage(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }

    @FindBy(css = ".product-line-info a")
    private WebElement name;

    @FindBy(css = "span.price")
    private WebElement quantityPrice;

    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement quantity;

    @FindBy(css = "span.product-price")
    private WebElement totalPrice;


    public String getName() {
        return name.getText().trim();
    }

    public double getQuantityPrice() {
        String price = quantityPrice.getText();
        String plainPriceValue = price.replace("$", "");
        return Double.parseDouble(plainPriceValue);
    }

    public double getTotalPrice() {
        String price = totalPrice.getText();
        String plainPriceValue = price.replace("$", "");
        return Double.parseDouble(plainPriceValue);
    }

    public int getQuantity() {
        String value = quantity.getAttribute("value");
        return Integer.parseInt(value);
    }
}
