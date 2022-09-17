package SearchTests;

import Base.BaseTest;
import PageObjects.*;
import PageObjects.Widgets.SearchWidget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(SearchTest.class);

    SearchWidget searchWidget;
    SearchResultsPage searchResultsPage;
    ProductGridPage productGridPage;

    @BeforeEach
    public void testSetup() {
        searchWidget = new SearchWidget(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productGridPage = new ProductGridPage(driver);
    }

    @Test
    @DisplayName("Search for random product")
    public void searchForProduct() {
        logger.info(">>>> Start test Random Product >>>>>");
        String expectedProductName = productGridPage.getRandomProductName();
        logger.info("Expected product name: " + expectedProductName);
        searchWidget.searchWithClick(expectedProductName);
        String actualProductName = searchResultsPage.getProductName();
        logger.info("Actual product name: " + actualProductName);
        assertThat(actualProductName).isEqualTo(expectedProductName);
        logger.info(">>>> End of Random Product Search >>>>>");
    }

    @Test
    @DisplayName("Search test Dropdown")
    public void searchDropdownTest() {
        logger.info(">>>> Start test Dropdown >>>>>");
        String searchItem = "hummingbird";
        searchWidget.searchWithoutClick(searchItem);
        searchWidget.waitToBeVisible(searchWidget.getSearchResultDropDownList());
        String textValue;
        for(int i=0; i<searchWidget.getSearchResultDropDownItem().size(); i++) {
            WebElement myElement = searchWidget.getSearchResultDropDownItem().get(i);
            textValue = myElement.getText();
            assertThat(textValue).contains(searchItem.toUpperCase(Locale.ROOT));
            logger.info("Search result value " + textValue);
        }
    }
}
