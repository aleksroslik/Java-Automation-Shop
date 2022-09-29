package PageObjects.Checkout;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingPage extends BasePage {
    public ShippingPage(WebDriver driver) {super(driver);
    }

    @FindBy(css="[name='confirmDeliveryOption']")
    private WebElement continueToNextSection;

    public PaymentsPage continueToPayments() {
        wait.until(ExpectedConditions.elementToBeClickable(continueToNextSection));
        click(continueToNextSection);
        return new PaymentsPage(driver);
    }
}
