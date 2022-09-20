package PageObjects.Components;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductGrid extends BasePage {

    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-title")
    private List<WebElement> productMiniatures;

    public List<WebElement> getProductMiniatures() {
        return productMiniatures;
    }

    public void clickRandomProduct() {
        WebElement randomProduct = getRandomElement(productMiniatures);
        click(randomProduct);
    }

    public String getRandomProductName() {
        return getRandomElement(productMiniatures).getText();
    }

    public int productListSize() {
        return productMiniatures.size();
    }
}
