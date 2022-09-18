package PageObjects.Widgets;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.FindBy;

import java.awt.event.MouseEvent;
import java.util.List;

public class CategoryList extends BasePage {

    public CategoryList(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-depth='0']")
    private List<WebElement> topCategoryItems;

    @FindBy(css = "a[data-depth='1']")
    private List<WebElement> subCategoryMenuItems;

    public List<WebElement> getSubCategoryMenuItems() {
        return subCategoryMenuItems;
    }

    public List<WebElement> getTopCategoryItems() {
        return topCategoryItems;
    }

    @FindBy(id = "top-menu")
    private WebElement topMenu;

    public WebElement getTopMenu() {
        return topMenu;
    }

    @FindBy(id = "category-3")
    private WebElement clothes;

    @FindBy(id = "category-6")
    private WebElement accessories;

    @FindBy(id = "category-9")
    private WebElement art;

    @FindBy(css = "li#category-4")
    private WebElement men;

    @FindBy(css = "li#category-5")
    private WebElement women;

    @FindBy(css = "li#category-7")
    private WebElement stationery;

    @FindBy(css = "li#category-8")
    private WebElement homeAccessories;

    public void clickOnCategory(WebElement element) {
        click(element);
    }

    public void moveToCategoryClothes() {
        actions.moveToElement(clothes).perform();
    }

    public void moveToCategoryAccessories() {
        actions.moveToElement(accessories).perform();
    }
}
