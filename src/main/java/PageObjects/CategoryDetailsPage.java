package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

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

    @FindBy(css = "span.price")
    private WebElement productPrice;

    @FindBy(className = "filter-block")
    private WebElement filterPriceRange;


    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

    public String getResultsLabelText() {
        return resultsLabel.getText();
    }

    public String getFilterPriceRangeText() {
        return filterPriceRange.getText();
    }

    /*public BigDecimal getProductPrice() {
        String price = productPrice.getText();
        String priceWithoutCurrency = price.replace("$", "");
        return new BigDecimal(priceWithoutCurrency);
    }*/

    public Double getProductPrice() {
        String price = productPrice.getText();
        String priceWithoutCurrency = price.replace("$", "");
        return Double.parseDouble(priceWithoutCurrency);
    }
}
