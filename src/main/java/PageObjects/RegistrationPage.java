package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "id_gender")
    private WebElement genderBtn;

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

    public void setGenderBtn(WebElement genderBtn) {
        this.genderBtn = genderBtn;
    }

    public void setFirstName(WebElement firstName) {
        this.firstName = firstName;
    }

    public void setLastName(WebElement lastName) {
        this.lastName = lastName;
    }

    public void setEmail(WebElement email) {
        this.email = email;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public void setDateOfBirth(WebElement dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public RegistrationPage acceptAgreements() {
        checkboxAccept.click();
        checkboxNewsLetter.click();
        checkboxPrivacy.click();
        checkboxOffers.click();
        return this;
    }
}
