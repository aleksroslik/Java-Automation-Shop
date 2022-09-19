package PageObjects;

import Base.BasePage;
import Models.User.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[title] .hidden-sm-down")
    private WebElement login;

    public HomePage goToLoginPage() {
        click(login);
        return this;
    }
}
