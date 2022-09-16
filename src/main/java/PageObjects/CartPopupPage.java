package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopupPage extends BasePage {

    public CartPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.btn-primary")
    private WebElement goToCartBtn;

    public void goToCart() {
        click(goToCartBtn);
    }
}
