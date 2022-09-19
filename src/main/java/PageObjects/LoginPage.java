package PageObjects;

import Base.BasePage;
import Models.User.User;
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

    public void loginUser(String email, String pass) {
        sendKeys(this.email, email);
        sendKeys(this.pass, pass);
        click(loginBtn);
    }

    public void openRegisterPage() {
        click(registerBtn);
    }

    public LoginPage goToRegistration() {
        click(registerBtn);
        return this;
    }

    public void login(User user) {
        sendKeys(email, user.getEmail());
        sendKeys(pass, user.getPassword());
        click(loginBtn);
    }
}
