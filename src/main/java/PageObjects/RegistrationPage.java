package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

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
}
