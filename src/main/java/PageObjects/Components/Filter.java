package PageObjects.Components;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Filter extends BasePage {

    public Filter(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "search_filters")
    private WebElement filterPanel;

    @FindBy(className = "ps-shown-by-js")
    private List<WebElement> checkboxList;

    @FindBy(css = ".js-search-filters-clear-all")
    private WebElement clearBtn;

    @FindBy(css = "[aria-disabled] .ui-corner-all:nth-child(3)")
    private WebElement sliderRight;

    public WebElement getSliderRight() {
        return sliderRight;
    }

    @FindBy(css = "[aria-disabled] .ui-corner-all:nth-child(2)")
    WebElement dataSlider;

    public WebElement getDataSlider() {
        return dataSlider;
    }

    @FindBy(css = "#slider-range_71913 a:nth-child(2)")
    private WebElement sliderLeft;

    public WebElement getFilterPanel() {
        return filterPanel;
    }

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }

    public void slideToLocationLeft(int xTimes) throws InterruptedException {
        for (int i=1; i<xTimes; i++) {
            Thread.sleep(300);
            sliderRight.sendKeys(Keys.ARROW_LEFT);
        }
        sliderRight.sendKeys(Keys.ENTER);
    }

    public void clearFilter() throws InterruptedException {
        Thread.sleep(500);
        clearBtn.click();
        Thread.sleep(500);
    }
}
