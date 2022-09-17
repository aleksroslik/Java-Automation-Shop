package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductGridPage extends BasePage {

    public ProductGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-title")
    private List<WebElement> productMiniatures;

    public void openRandomProduct() {
        WebElement randomProduct = getRandomElement(productMiniatures);
        click(randomProduct);
    }

    public String getRandomProductName() {
        return getRandomElement(productMiniatures).getText();
    }
}
