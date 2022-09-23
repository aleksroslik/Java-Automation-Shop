package ProductsAndCategoriesTests;

import Base.BaseTest;
import PageObjects.CategoryDetailsPage;
import PageObjects.Components.CategoriesList;
import PageObjects.Components.Filter;
import PageObjects.Components.ProductGrid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CategoriesTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(CategoriesTest.class);

    CategoriesList categoriesList;
    CategoryDetailsPage categoryDetailsPage;
    Filter filter;
    ProductGrid productGrid;

    @BeforeEach
    public void testSetup() {
        categoriesList = new CategoriesList(driver);
        categoryDetailsPage = new CategoryDetailsPage(driver);
        filter = new Filter(driver);
        productGrid = new ProductGrid(driver);
    }

    @Test
    @DisplayName("Main categories test")
    public void mainCategoryIteration() {
        logger.info(">>>> Start test Top Categories Check >>>>>");
        categoriesList.waitToBeVisible(categoriesList.getTopMenu());
        for(int i = 0; i< categoriesList.topCategoriesListSize(); i++) {
            verifyTopCategoryNameWithCategoryPageTitle(i);
            confirmThatFilterIsVisible();
            compareNumberOfItemsFoundWithSearchResults();
        }
        logger.info(">>>> End test Top Categories Check >>>>>");
    }

    @Test
    @DisplayName("Sub categories test")
    public void subCategoryIteration() {
        logger.info(">>>> Start test Sub Categories Check >>>>>");
        categoriesList.waitToBeVisible(categoriesList.getTopMenu());
        for (int i = 0; i < categoriesList.subCategoriesListSize(); i++) {
            categoriesList.moveToElement(categoriesList.getClothes());
            verifySubCategoryNameWithCategoryPageTitle(i);
            confirmThatFilterIsVisible();
            compareNumberOfItemsFoundWithSearchResults();
            categoriesList.moveToElement(categoriesList.getAccessories());
        }
        logger.info(">>>> End test Sub Categories Check >>>>>");
    }

    private void verifyTopCategoryNameWithCategoryPageTitle(int i) {
        String categoryName = categoriesList.getTopCategoryTitle(i);
        categoriesList.clickOnCategory(categoriesList.getTopCategory(i));
        String catTitle = categoryDetailsPage.getCategoryTitle();
        logger.info("Top category title " + catTitle);
        assertThat(categoryName).isEqualTo(catTitle);
    }

    private void verifySubCategoryNameWithCategoryPageTitle(int i) {
        String categoryName = categoriesList.getSubCategoryTitle(i);
        categoriesList.clickOnCategory(categoriesList.getSubCategory(i));
        String catTitle = categoryDetailsPage.getCategoryTitle();
        logger.info("Top category title " + catTitle);
        assertThat(categoryName).isEqualTo(catTitle);
    }

    public void confirmThatFilterIsVisible() {
        boolean isFilterDisplayed = filter.confirmFilterIsDisplayed();
        logger.info("Filter display: " + isFilterDisplayed);
    }

    private void compareNumberOfItemsFoundWithSearchResults() {
        String results = String.valueOf(productGrid.productListSize());
        logger.info("List of elements displayed " + results);
        String actualResults = categoryDetailsPage.getResultsLabelText();
        logger.info("List of actual elements " + actualResults);
        assertThat(actualResults).contains(results);
    }
}
