package PageObjects.Widgets;

import Base.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchWidget extends BasePage {

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "ui-autocomplete-input")
    private WebElement searchInput;

    @FindBy(css = "i.search")
    private WebElement searchButton;

    @FindBy(css = "ul#ui-id-1")
    private WebElement searchResultDropDownList;

    @FindBy(css = "ul.ui-autocomplete li")
    private List<WebElement> searchResultDropDownItem;

    public List<WebElement> getSearchResultDropDownItem() {
        return searchResultDropDownItem;
    }

    public WebElement getSearchResultDropDownList() {
        return searchResultDropDownList;
    }

    public void searchWithClick(String productName) {
        sendKeys(searchInput, productName);
        click(searchButton);
    }

    public void searchWithoutClick(String productName) {
        sendKeys(searchInput, productName);
    }
}
