package Registration.ProductsAndCategoriesTests;

import Base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FiltersTest extends Pages {

    private static final Logger logger = LoggerFactory.getLogger(FiltersTest.class);

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
            assertThat(price).isBetween(9.00, 10.00);
        }
    }
}
