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

import java.util.List;

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
            verifyCategoryNameWithCategoryPageTitle(categoryList.getTopCategoryItems(), i);
            confirmFilterIsDisplayed(filter.getFilterPanel());
            confirmNumberOfItemsFoundWithSearchResults();
        }
        logger.info(">>>> End test Top Categories Check >>>>>");
    }

    @Test
    @DisplayName("Sub categories test")
    public void subCategoryIteration() {
        logger.info(">>>> Start test Sub Categories Check >>>>>");
        categoryList.waitToBeVisible(categoryList.getTopMenu());
        for (int i = 0; i < categoryList.getSubCategoryMenuItems().size(); i++) {
            categoryList.moveToCategoryClothes();
            verifyCategoryNameWithCategoryPageTitle(categoryList.getSubCategoryMenuItems(), i);
            confirmFilterIsDisplayed(filter.getFilterPanel());
            confirmNumberOfItemsFoundWithSearchResults();
            categoryList.moveToCategoryAccessories();
        }
        logger.info(">>>> End test Sub Categories Check >>>>>");
    }

    private void verifyCategoryNameWithCategoryPageTitle(List<WebElement> element, int i) {
        WebElement catItem = element.get(i);
        String categoryName = catItem.getText();
        logger.info("Menu item title " + categoryName);
        categoryList.clickOnCategory(catItem);
        String catTitle = categoryDetailsPage.getCategoryTitle();
        logger.info("Top category title " + catTitle);
        assertThat(categoryName).isEqualTo(catTitle);
    }

    private void confirmFilterIsDisplayed(WebElement element) {
        boolean elementIsDisplayed = element.isDisplayed();
        assertThat(elementIsDisplayed).isTrue();
    }

    public void confirmNumberOfItemsFoundWithSearchResults() {
        String results = String.valueOf(productGrid.productListSize());
        logger.info("List of elements displayed " + results);
        String actualResults = categoryDetailsPage.getResultsLabelText();
        logger.info("List of actual elements " + actualResults);
        assertThat(actualResults).contains(results);
    }
}
