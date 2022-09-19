package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

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
}
