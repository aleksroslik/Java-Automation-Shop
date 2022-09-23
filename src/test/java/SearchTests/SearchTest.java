package SearchTests;

import Base.BaseTest;
import PageObjects.*;
import PageObjects.Components.ProductGrid;
import PageObjects.Components.SearchWidget;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(SearchTest.class);

    SearchWidget searchWidget;
    SearchResultsPage searchResultsPage;
    ProductGrid productGrid;

    @BeforeEach
    public void testSetup() {
        searchWidget = new SearchWidget(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productGrid = new ProductGrid(driver);
    }

    @Test
    @DisplayName("Search for random product")
    public void searchForRandomProduct() {
        logger.info(">>>> Start test Random Product >>>>>");
        String expectedProductName = productGrid.getRandomProductName();
        logger.info("Expected product name: " + expectedProductName);
        searchWidget.searchWithClick(expectedProductName);
        String actualProductName = searchResultsPage.getProductName();
        logger.info("Actual product name: " + actualProductName);
        assertThat(actualProductName).isEqualTo(expectedProductName);
        logger.info(">>>> End of Random Product Search test >>>>>");
    }

    @Test
    @DisplayName("Search test Dropdown")
    public void searchInputDropdownTest() {
        logger.info(">>>> Start test Dropdown >>>>>");
        String searchItem = "HUMMINGBIRD";
        searchWidget.searchWithoutClick(searchItem);
        for(int i=0; i<searchWidget.getSearchDropdownListSize(); i++) {
            searchWidget.getSearchResultsItem(i);
            String textValue = searchWidget.getSearchResultItemText(i);
            assertThat(textValue).contains(searchItem);
            logger.info("Search result value: " + textValue);
        }
        logger.info(">>>> End of Dropdown Search test >>>>>");
    }
}
