package PageObjects.Cart;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class CartItemPage extends BasePage {

    public CartItemPage(WebDriver driver, WebElement item) {
        super(driver);
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
        return getPrice(quantityPrice);
    }

    public double getTotalPrice() {
        return getPrice(totalPrice);
    }

    public int getQuantity() {
        String value = quantity.getAttribute("value");
        return Integer.parseInt(value);
    }
}
