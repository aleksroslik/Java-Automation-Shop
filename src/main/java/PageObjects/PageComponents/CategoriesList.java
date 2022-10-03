package PageObjects.PageComponents;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoriesList extends BasePage {

    public CategoriesList(WebDriver driver) {
        super(driver);
    }

    private static final Logger logger = LoggerFactory.getLogger(CategoriesList.class);

    @FindBy(css = "a[data-depth='0']")
    private List<WebElement> topCategoryItems;

    @FindBy(css = "a[data-depth='1']")
    private List<WebElement> subCategoryMenuItems;

    @FindBy(id = "top-menu")
    private WebElement topMenu;

    @FindBy(id = "category-3")
    private WebElement clothes;

    @FindBy(id = "category-6")
    private WebElement accessories;

    @FindBy(id = "category-9")
    private WebElement art;

    public WebElement getClothes() {
        return clothes;
    }

    public WebElement getAccessories() {
        return accessories;
    }

    public void clickOnCategory(WebElement element) {
        click(element);
    }

    public void clickOnArtCategory() {
        click(art);
    }

    public int topCategoriesListSize() {
        return topCategoryItems.size();
    }

    public int subCategoriesListSize() {
        return subCategoryMenuItems.size();
    }

    public WebElement getTopCategory(int i) {
        return topCategoryItems.get(i);
    }

    public WebElement getSubCategory(int i) {
        return subCategoryMenuItems.get(i);
    }

    public String getTopCategoryTitle(int i) {
        WebElement catItem = topCategoryItems.get(i);
        String categoryName = catItem.getText();
        logger.info("Menu item title " + categoryName);
        return categoryName;
    }

    public String getSubCategoryTitle(int i) {
        WebElement catItem = subCategoryMenuItems.get(i);
        String categoryName = catItem.getText();
        logger.info("Menu item title " + categoryName);
        return categoryName;
    }

    public void waitForVisibilityOfTopCategories() {
        waitToBeVisible(topMenu);
    }
}
