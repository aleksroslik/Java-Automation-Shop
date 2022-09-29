package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {super(driver);
    }

    @FindBy(css = "a.btn.btn-primary")
    private WebElement proceed;

    public void proceed() {
        click(proceed);
    }
}
