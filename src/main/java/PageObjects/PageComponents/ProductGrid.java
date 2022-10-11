package PageObjects.PageComponents;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class ProductGrid extends BasePage {

    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-title")
    private List<WebElement> productMiniatures;


    public void openProductByName(String expectedName) {
        for (WebElement product : productMiniatures) {
            String textValue = product.getText();
            if (Objects.equals(textValue, expectedName)) {
                click(product);
                break;
            }
        }
    }

    public String getRandomProductName() {
        return getRandomElement(productMiniatures).getText();
    }

    public int productListSize() {
        return productMiniatures.size();
    }

    public void getMiniature(int i) {
    }

    public void openRandomProduct() {
        WebElement randomProduct = getRandomElement(productMiniatures);
        click(randomProduct);
    }
}
