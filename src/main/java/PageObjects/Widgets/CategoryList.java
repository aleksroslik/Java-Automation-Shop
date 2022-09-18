package PageObjects.Widgets;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryList extends BasePage {

    public CategoryList(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-depth='0']")
    private List<WebElement> topCategoryItems;

    @FindBy(css = "a.dropdown-submenu")
    private List<WebElement> subCategoryMenuItems; // to jest ok ma 4 elementy

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

    public void moveToCategoryWomen() {
        actions.moveToElement(women);
    }
}
