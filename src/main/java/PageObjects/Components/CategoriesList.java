package PageObjects.Components;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoriesList extends BasePage {

    public CategoriesList(WebDriver driver) {
        super(driver);
    }

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

    @FindBy(css = "li#category-4")
    private WebElement men;

    @FindBy(css = "li#category-5")
    private WebElement women;

    @FindBy(css = "li#category-7")
    private WebElement stationery;

    @FindBy(css = "li#category-8")
    private WebElement homeAccessories;

    public WebElement getTopMenu() {
        return topMenu;
    }

    public WebElement getClothes() {
        return clothes;
    }

    public WebElement getArt() {
        return art;
    }

    public WebElement getAccessories() {
        return accessories;
    }

    public List<WebElement> getSubCategoryMenuItems() {
        return subCategoryMenuItems;
    }

    public List<WebElement> getTopCategoryItems() {
        return topCategoryItems;
    }

    public void clickOnCategory(WebElement element) {
        click(element);
    }

    public void clickOnArtCategory() {
        click(art);
    }

    public void clickOnClothesCategory() {
        click(clothes);
    }

    public void clickOnAccessoriesCategory() {
        click(accessories);
    }
}