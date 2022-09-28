package PageObjects.Components;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.cart-products-count")
    private WebElement basketCount;

    @FindBy(id = "_desktop_cart")
    private WebElement basketBtn;

    public String getCartValue() {
        return basketCount.getText();
    }

    public void goToCart() {
        click(basketBtn);
    }
}
