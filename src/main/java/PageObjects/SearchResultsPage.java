package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-title")
    private WebElement productName;

    @FindBy(className = "col-md-4")
    private WebElement foundItemsBottomLabel;

    @FindBy(className = "total-products")
    private WebElement foundItemsTopLabel;

    public String getProductName() {
        return productName.getText();
    }
}
