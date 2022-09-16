import Base.BaseTest;
import PageObjects.CartPage;
import PageObjects.CartPopupPage;
import PageObjects.ProductDetailsPage;
import PageObjects.ProductGridPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasketTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BasketTest.class);

    ProductDetailsPage productDetailsPage;
    ProductGridPage productGridPage;
    CartPopupPage cartPopupPage;
    CartPage cartPage;

    @BeforeEach
    public void testSetup() {
        productDetailsPage = new ProductDetailsPage(driver);
        productGridPage = new ProductGridPage(driver);
        cartPopupPage = new CartPopupPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    @DisplayName("Add expected product quantity to basket test")
    public void addExpectedProductQuantityToBasket() throws InterruptedException {
        logger.info(">>>> Start test Add product to Basket >>>>>");
        productGridPage.openRandomProduct();
        int expectedQuantity = 4;
        String expectedProductName = productDetailsPage.getProductName();
        Thread.sleep(1000);
        BigDecimal expectedPrice = productDetailsPage.getProductPrice();
        BigDecimal expectedTotalProductPrice = expectedPrice.multiply(new BigDecimal(expectedQuantity));
        logger.info(">>>> Adding product to Basket >>>>>");
        productDetailsPage.setQuantity(expectedQuantity);
        productDetailsPage.addToCart();
        cartPopupPage.goToCart();

        assertThat(cartPage.getProductName()).isEqualTo(expectedProductName);
        assertThat(cartPage.getProductPrice()).isEqualTo(expectedPrice);
        assertThat(cartPage.getProductQuantity()).isEqualTo(expectedQuantity);
        assertThat(cartPage.getTotalProductPrice()).isEqualTo(expectedTotalProductPrice);
        logger.info(">>>> Finish test Add product to Basket >>>>>");
    }
}
