package PageObjects.PageComponents;

import Base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Filter extends BasePage {

    public Filter(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_filters")
    private WebElement filterPanel;

    @FindBy(css = ".js-search-filters-clear-all")
    private WebElement clearBtn;

    @FindBy(xpath= "//div[contains(@class, 'ui-slider')]/a[2]")
    private WebElement sliderRight;

    @FindBy(xpath= "//div[contains(@class, 'ui-slider')]/a[1]")
    private WebElement sliderLeft;

    public boolean confirmFilterIsDisplayed() {
        return filterPanel.isDisplayed();
    }

    public void slideToChangePriceRange() {
        int priceRange = 20;
        for (int i=1; i<priceRange; i++) {
            scheduleWait(400);
            sliderRight.sendKeys(Keys.ARROW_LEFT);
        }
    }

    public void clearFilter() {
        waitToBeClickable(clearBtn);
        clearBtn.click();
        waitForUrlToBe("http://146.59.32.4/index.php?id_category=9&controller=category&id_lang=2");
    }
}
