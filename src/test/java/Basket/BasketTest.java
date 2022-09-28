package Basket;

import Base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasketTest extends Pages {

    private static final Logger logger = LoggerFactory.getLogger(BasketTest.class);

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

    @Test
    @DisplayName("Add random products to basket test")
    public void addRandomProductsToBasket() {
        logger.info(">>>> Start test add random products to Basket >>>>>");

        addMultipleProductsToCart(5);

        header.goToCart();
    }

    private void addMultipleProductsToCart(int numberOfTimes) {
        for(int i = 0; i < numberOfTimes; i++) {
            productGrid.openRandomProduct();
            productDetailsPage.addToCart();
            cartPopupPage.continueShopping();
            mainMenu.goToMainPage();
        }
    }
}
