package ProductsAndCategoriesTests;

import Base.BaseTest;
import PageObjects.CategoryDetailsPage;
import PageObjects.Components.CategoriesList;
import PageObjects.Components.Filter;
import PageObjects.Components.ProductGrid;
import com.sun.jdi.DoubleValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigDecimal;

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
    public void filtersTest() throws InterruptedException {
        logger.info(">>>> Start test Filters >>>>>");

        categoriesList.clickOnArtCategory();
        int numberOfProductsDisplayed = productGrid.productListSize();
        logger.info("Number of products WITHOUT filter on " + numberOfProductsDisplayed);

        filter.slideToLocationLeft(20);
        int numberOfProductsWithFilter = productGrid.productListSize();
        logger.info("Number of products WITH filter on " + numberOfProductsWithFilter);

        Double price = categoryDetailsPage.getProductPrice();
        logger.info("Price " + price);

        assertThat(price).isBetween(9.0, 10.0);

        filter.clearFilter();
        int numberOfProductsAfterRefresh = productGrid.productListSize();
        logger.info("Number of Products after refresh " + numberOfProductsAfterRefresh);
    }
}
