package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryDetailsPage extends BasePage {

    public CategoryDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "category-top-menu")
    private WebElement categoryLabel;

    @FindBy(className = "h1")
    private WebElement categoryTitle;

    @FindBy(id = "search_filters")
    private WebElement filterPanel;

    @FindBy(className = "total-products")
    private WebElement resultsLabel;

    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

    public String getResultsLabelText() {
        return resultsLabel.getText();
    }
}
