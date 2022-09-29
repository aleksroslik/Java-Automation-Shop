package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#history-link > span > i")
    private WebElement orderHistoryBtn;

    public void goToOrderHistory() {
        click(orderHistoryBtn);
    }

}
