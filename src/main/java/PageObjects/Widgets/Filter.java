package PageObjects.Widgets;

import Base.BasePage;
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

    public WebElement getFilterPanel() {
        return filterPanel;
    }

    public List<WebElement> getCheckboxList() {
        return checkboxList;
    }
}
