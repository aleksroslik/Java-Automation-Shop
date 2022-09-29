package PageObjects.Checkout;

import Base.BasePage;
import DataProviders.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressPage extends BasePage {

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LoggerFactory.getLogger(AddressPage.class);

    @FindBy(css="[name='address1']")
    private WebElement address;

    @FindBy(css="[name='address1']")
    private WebElement alternativeAddress;

    @FindBy(css="[name='city']")
    private WebElement city;

    @FindBy(css="[name='postcode']")
    private WebElement postalCode;

    @FindBy(css = "[name='id_state']")
    private WebElement state;

    @FindBy(css="[name='id_country']")
    private WebElement countrySelect;

    @FindBy(css="[data-link-action='different-invoice-address']")
    private WebElement invoiceAddress;

    @FindBy(css="[name='confirm-addresses']")
    private WebElement continueToNextSection;

    @FindBy(css = "#checkout-addresses-step span.step-edit.text-muted")
    private WebElement editAddress;

    @FindBy(css = "input#use_same_address")
    private WebElement sameAddressBtn;

    @FindBy(css = "#id-address-invoice-address-5135 input[type=radio]")
    private WebElement invoiceAddressReady;

    public AddressPage setUserAddress(User user) {
        sendKeys(address, user.getAddress());
        sendKeys(city, user.getCity());
        sendKeys(postalCode, user.getPostalCode());
        setCountry("Poland");
        logger.info(user.getAddress() + "," + user.getCity() + "," + user.getPostalCode());
        return this;
    }

    public void setAlternativeUserAddress(User user) {
        sendKeys(alternativeAddress, user.getAlternativeAddress());
        sendKeys(city, user.getCity());
        sendKeys(postalCode, user.getPostalCode());
        setCountry("Poland");
        logger.info(user.getAlternativeAddress() + "," + user.getCity() + "," + user.getPostalCode());
    }

    public AddressPage changeBillingAddress(User user) {
        click(invoiceAddress);
        setAlternativeUserAddress(user);
        waitToBeClickable(continueToNextSection);
        return this;
    }

    public void setCountry(String country) {
        new Select(countrySelect).selectByVisibleText(country);
    }

    public void continueToShipping(){
        scrollTo(continueToNextSection);
        click(continueToNextSection);
        new ShippingPage(driver);
    }
}
