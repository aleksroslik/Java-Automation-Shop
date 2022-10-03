package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryDetailsPage extends BasePage {

    public CategoryDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "h1")
    private WebElement categoryTitle;

    @FindBy(className = "total-products")
    private WebElement resultsLabel;

    @FindBy(css = "span.price")
    private WebElement productPrice;

    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

    public String getResultsLabelText() {
        return resultsLabel.getText();
    }

    public double getProductPrice() {
        return getPrice(productPrice);
    }
}
