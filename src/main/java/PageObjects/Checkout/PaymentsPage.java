package PageObjects.Checkout;

import Base.BasePage;
import PageObjects.Order.OrderConfirmationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage extends BasePage {
    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#payment-option-1")
    private WebElement payByCheckOption;

    @FindBy(css="[id='conditions_to_approve[terms-and-conditions]']")
    private WebElement termsAgreement;

    @FindBy(css="#payment-confirmation .btn-primary")
    private WebElement placeOrderButton;

    public PaymentsPage selectPayByCheck() {
        click(payByCheckOption);
        return this;
    }

    public PaymentsPage agreeToTerms() {
        click(termsAgreement);
        return this;
    }

    public void confirmOrder() {
        click(placeOrderButton);
        new OrderConfirmationPage(driver);
    }
}
