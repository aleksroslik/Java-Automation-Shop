package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(id = "submit-login")
    WebElement loginBtn;

    public void loginUser(String email, String pass) {
        sendKeys(this.email, email);
        sendKeys(this.pass, pass);
        click(loginBtn);
    }
}
