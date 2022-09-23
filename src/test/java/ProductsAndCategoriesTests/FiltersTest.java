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

public class FiltersTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(FiltersTest.class);

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
    @DisplayName("Filters test")
    public void filtersTest() {
        logger.info(">>>> Start test Filters >>>>>");
        categoriesList.clickOnArtCategory();

        int numberOfProductsDisplayed = productGrid.productListSize();
        logger.info("Number of products WITHOUT filter on " + numberOfProductsDisplayed);

        filter.slideToChangePriceRange();

        verifyPriceForEachProduct();

        filter.clearFilter();

        int numberOfProductsAfterRefresh = productGrid.productListSize();
        logger.info("Number of Products after refresh " + numberOfProductsAfterRefresh);

        assertThat(numberOfProductsAfterRefresh).isEqualTo(numberOfProductsDisplayed);
        logger.info(">>>> End Filters test >>>>>");
    }

    private void verifyPriceForEachProduct() {
        for (int i = 0; i < productGrid.productListSize(); i++) {
            productGrid.getMiniature(i);
            double price = categoryDetailsPage.getProductPrice();
            logger.info("Price: " + price);
            assertThat(price).isBetween(9.0, 10.0);
        }
    }
}
