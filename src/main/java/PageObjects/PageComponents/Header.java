package PageObjects.PageComponents;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.cart-products-count")
    private WebElement basketCount;

    @FindBy(id = "_desktop_cart")
    private WebElement basketBtn;

    @FindBy(css = "[title] .hidden-sm-down")
    private WebElement login;

    @FindBy(className = "account")
    private WebElement accountName;

    public void goToLoginPage() {
        click(login);
    }

    public String getAccountNameText() {
        return accountName.getText();
    }

    public String getCartValue() {
        return basketCount.getText();
    }

    public void goToCart() {
        click(basketBtn);
        try {
            takeScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void goToAccount() {
        click(accountName);
    }
}
