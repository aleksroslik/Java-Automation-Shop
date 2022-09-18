package ProductsAndCategoriesTests;

import Base.BaseTest;
import PageObjects.CategoryDetailsPage;
import PageObjects.Widgets.CategoryList;
import PageObjects.Widgets.Filter;
import PageObjects.Widgets.ProductGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CategoriesTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CategoriesTest.class);

    CategoryList categoryList;
    CategoryDetailsPage categoryDetailsPage;
    Filter filter;
    ProductGrid productGrid;

    @BeforeEach
    public void testSetup() {
        categoryList = new CategoryList(driver);
        categoryDetailsPage = new CategoryDetailsPage(driver);
        filter = new Filter(driver);
        productGrid = new ProductGrid(driver);
    }

    @Test
    @DisplayName("Main categories test")
    public void mainCategoryIteration() {
        logger.info(">>>> Start test Top Categories Check >>>>>");
        categoryList.waitToBeVisible(categoryList.getTopMenu());
        for(int i=0; i<categoryList.getTopCategoryItems().size(); i++) {
            verifyTopCategoryNameWithCategoryPageTitle(i);
            confirmFilterIsDisplayed();
            confirmNumberOfItemsFoundWithSearchResults();
        }
        logger.info(">>>> End test Top Categories Check >>>>>");
    }

    @Test
    @DisplayName("Sub categories test")
    public void subCategoryIteration() {
        logger.info(">>>> Start test Top Categories Check >>>>>");
        categoryList.waitToBeVisible(categoryList.getTopMenu());
        //hover to 1 element on top list
        //sublista powinna sie wyswietlic
        //petla, gdzie jest sub category item i tam przetwarza sie wszystkie akcje od click po weryfikacje
    }

    private void verifyTopCategoryNameWithCategoryPageTitle(int i) {
        WebElement catItem = categoryList.getTopCategoryItems().get(i);
        String categoryName = catItem.getText();
        logger.info("Menu item title " + categoryName);
        categoryList.clickOnCategory(catItem);
        String catTitle = categoryDetailsPage.getCategoryTitle();
        logger.info("Top category title " + catTitle);
        assertThat(categoryName).isEqualTo(catTitle);
    }

    private void confirmFilterIsDisplayed() {
        boolean filterIsDisplayed = filter.getFilterPanel().isDisplayed();
        assertThat(filterIsDisplayed).isTrue();
    }

    public void confirmNumberOfItemsFoundWithSearchResults() {
        String results = String.valueOf(productGrid.productListSize());
        logger.info("List of elements displayed " + results);
        String actualResults = categoryDetailsPage.getResultsLabelText();
        logger.info("List of actual elements " + actualResults);
        assertThat(actualResults).contains(results);
    }
}
