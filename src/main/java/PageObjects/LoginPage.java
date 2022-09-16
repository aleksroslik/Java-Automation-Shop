package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "emailBtn") // do sprawdzenia lokator
    WebElement email;

    @FindBy(css = "passBtn") // do sprawdzenia lokator
    WebElement pass;

    @FindBy(css = "loginBtn")
    WebElement loginBtn;

    public void loginUser(String email, String pass) {
        sendKeys(this.email, email);
        sendKeys(this.pass, pass);
        click(loginBtn);
    }
}
