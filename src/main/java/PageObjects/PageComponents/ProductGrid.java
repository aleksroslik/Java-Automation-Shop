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

    @FindBy(css = "div:nth-child(2) > h2")
    private List<WebElement> productDescription;


    public void openProductByName(String expectedName) {
        try {
            for (WebElement product : productDescription) {
                String textValue = product.getText();
                if (Objects.equals(textValue, expectedName)) {
                    click(product);
                }
            }
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            for (WebElement product : productDescription) {
                String textValue = product.getText();
                if (Objects.equals(textValue, expectedName)) {
                    click(product);
                }
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
