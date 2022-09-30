package PageObjects;

import Base.BasePage;
import Models.User;
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

    @FindBy(className = "no-account")
    WebElement registerBtn;

    public void goToRegistration() {
        click(registerBtn);
    }

    public void loginUser(User user) {
        sendKeys(email, user.getEmail());
        sendKeys(pass, user.getPassword());
        click(loginBtn);
    }
}
