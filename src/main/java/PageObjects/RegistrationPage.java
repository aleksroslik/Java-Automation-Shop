package PageObjects;

import Base.BasePage;
import Models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "radio-inline")
    private List<WebElement> socialTitle;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "birthday")
    private WebElement dateOfBirth;

    @FindBy(name = "optin")
    private WebElement checkboxOffers;

    @FindBy(name = "customer_privacy")
    private WebElement checkboxPrivacy;

    @FindBy(name = "newsletter")
    private WebElement checkboxNewsLetter;

    @FindBy(name = "psgdpr")
    private WebElement checkboxAccept;

    @FindBy(css = "[data-link-action]")
    private WebElement submitBtn;

    public RegistrationPage selectRandomSocialTitle() {
        getRandomElement(socialTitle).click();
        return this;
    }

    public void submitForm() {
        click(submitBtn);
    }

    public RegistrationPage acceptAgreements() {
        checkboxAccept.click();
        checkboxNewsLetter.click();
        checkboxPrivacy.click();
        checkboxOffers.click();
        return this;
    }

    public RegistrationPage setUserData(User user) {
        sendKeys(firstName, user.getFirstName());
        sendKeys(lastName, user.getLastName());
        sendKeys(email, user.getEmail());
        sendKeys(password, user.getPassword());
        sendKeys(dateOfBirth, user.getBirthday());
        return this;
    }
}
