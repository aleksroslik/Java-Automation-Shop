package Basket;

import Base.BaseTest;
import PageObjects.CartPage;
import PageObjects.CartPopupPage;
import PageObjects.Components.CategoriesList;
import PageObjects.Components.Header;
import PageObjects.Components.ProductGrid;
import PageObjects.ProductDetailsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasketTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BasketTest.class);

    ProductDetailsPage productDetailsPage;
    ProductGrid productGrid;
    CartPopupPage cartPopupPage;
    CartPage cartPage;
    CategoriesList categoriesList;
    Header header;

    @BeforeEach
    public void testSetup() {
        productDetailsPage = new ProductDetailsPage(driver);
        cartPopupPage = new CartPopupPage(driver);
        cartPage = new CartPage(driver);
        categoriesList = new CategoriesList(driver);
        productGrid = new ProductGrid(driver);
        header = new Header(driver);
    }

    @Test
    @DisplayName("Add products to basket test")
    public void productSuccessfullyAddedToCart() {
        logger.info(">>>> Start test add products to Basket >>>>>");

        categoriesList.clickOnArtCategory();

        String expectedName = "THE BEST IS YET POSTER";
        productGrid.openProductByName(expectedName);

        int expectedQuantity = 3;
        productDetailsPage.setQuantity(expectedQuantity);
        productDetailsPage.addToCart();

        cartPopupPage.getProductDetails();

        double price = cartPopupPage.getProductPrice();
        double expectedTotalProductPrice = price*expectedQuantity;

        assertThat(cartPopupPage.getProductName()).isEqualTo(expectedName);
        assertThat(cartPopupPage.getProductQuantity()).contains(String.valueOf(expectedQuantity));
        assertThat(cartPopupPage.getTotalProductPrice()).isEqualTo(expectedTotalProductPrice);

        cartPopupPage.continueShopping();

        String cartValue = header.getCartValue();
        assertThat(cartValue).contains(String.valueOf(expectedQuantity));
        logger.info(">>>> Finish test add products to Basket >>>>>");
    }
}
