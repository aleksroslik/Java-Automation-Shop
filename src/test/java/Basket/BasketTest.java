package Basket;

import Base.Pages;
import Models.Cart;
import Models.OrderList;
import Models.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BasketTest extends Pages {

    private static final Logger logger = LoggerFactory.getLogger(BasketTest.class);

    OrderList orderList = new OrderList();

    @Test
    @DisplayName("Add products to basket test")
    public void productSuccessfullyAddedToCart() {
        logger.info(">>>> Start test add products to Basket >>>>>");

        categoriesList.clickOnArtCategory();

        String expectedName = "THE BEST IS YET POSTER";
        productGrid.openProductByName(expectedName);

        int expectedQuantity = 3;
        productDetailsPage.setQuantity(expectedQuantity)
                          .addToCart();

        cartPopupPage.getProductDetails();

        double price = cartPopupPage.getProductPrice();
        double expectedTotalProductPrice = price*expectedQuantity;

        assertThat(cartPopupPage.getProductName()).isEqualTo(expectedName);
        assertThat(cartPopupPage.getProductQuantityLabelText()).contains(String.valueOf(expectedQuantity));
        assertThat(cartPopupPage.getTotalProductPrice()).isEqualTo(expectedTotalProductPrice);

        cartPopupPage.continueShopping();

        String cartValue = header.getCartValue();
        assertThat(cartValue).contains(String.valueOf(expectedQuantity));
        logger.info(">>>> Finish test add products to Basket >>>>>");
    }

    @Test
    @DisplayName("Add random products and clear basket test")
    public void addRandomProductsAndClearBasket() {
        logger.info(">>>> Start test add random products and clear Basket >>>>>");

        for(int i = 0; i < 5; i++) {
            productGrid.openRandomProduct();
            productDetailsPage.setRandomQuantity()
                              .addToCart();
            orderList.addProductsToActualList(cartPopupPage);
            cartPopupPage.continueShopping();
            mainMenu.goToMainPage();
        }
        Cart actualCart = orderList.getShoppingCart();
        logger.info("Actual cart: " + actualCart.toString());

        header.goToCart();

        Cart expectedCart = shoppingCartPage.getShoppingCart();
        logger.info("Expected cart: " + expectedCart.toString());

        Assertions.assertThat(actualCart)
                .usingRecursiveComparison().isEqualTo(expectedCart);

        removeItemsOneByOneAndCompare();

        String emptyBasket = shoppingCartPage.getEmptyBasketText();
        assertThat(emptyBasket).isEqualTo("There are no more items in your cart");

        logger.info(">>>> End test add random products and clear Basket >>>>>");
    }

    private void removeItemsOneByOneAndCompare() {
        while(!orderList.isOrderListEmpty()) {
            Product item = orderList.getProducts().get(0);
            orderList.getProducts().remove(item);
            Cart actualCartAfterItemRemoval = orderList.getShoppingCart();
            shoppingCartPage.removeItem();
            logger.info("Actual cart after removing item: " + actualCartAfterItemRemoval.toString());
            Cart expectedCartAfterItemRemoval = shoppingCartPage.getShoppingCart();
            logger.info("Expected cart after removing item: " + expectedCartAfterItemRemoval.toString());
            Assertions.assertThat(actualCartAfterItemRemoval)
                    .usingRecursiveComparison().isEqualTo(expectedCartAfterItemRemoval);
        }
    }
}
