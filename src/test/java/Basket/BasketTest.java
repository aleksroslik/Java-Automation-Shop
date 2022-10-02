package Basket;

import Base.Pages;
import DataProviders.ProductFactory;
import Models.Cart;
import Models.Product;
import org.apache.commons.math3.util.Precision;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("Add random products to basket test")
    public void addRandomProductsToBasket() {
        logger.info(">>>> Start test add random products to Basket >>>>>");

        double totalPrice = 0;
        double shippingCost = 7;
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            productGrid.openRandomProduct();
            productDetailsPage.setRandomQuantity()
                    .addToCart();

            ProductFactory productFactory = new ProductFactory();
            Product product = productFactory.getProductInfo(cartPopupPage);

            boolean alreadyInBasket = false;
            for (Product p : products) {
                if (p.getName().equals(product.getName())) {
                    alreadyInBasket = true;
                    p.setQuantity(product.getQuantity());
                    p.setQuantityPrice(product.getQuantityPrice());
                    p.setTotalPrice(product.getTotalPrice());
                    break;
                }
            }
            if (!alreadyInBasket) {
                products.add(product);
            }

            totalPrice = totalPrice + product.getTotalPrice();

            cartPopupPage.continueShopping();
            mainMenu.goToMainPage();
        }
        Cart actualCart = new Cart(products, Precision.round(products.stream().mapToDouble(Product::getTotalPrice).sum(), 2) + shippingCost);
        logger.info("Actual cart: " + actualCart.toString());

        header.goToCart();
        List<Product> productInShoppingCartPage = shoppingCartPage.getAllProductsFromShoppingCart();
        double totalShoppingCartValue = shoppingCartPage.getTotalCartValue();
        Cart shoppingCart = new Cart(productInShoppingCartPage, totalShoppingCartValue);
        logger.info("Expected cart: " + shoppingCart.toString());

        Assertions.assertThat(actualCart).usingRecursiveComparison().isEqualTo(shoppingCart);

        logger.info(">>>> End test add random products to Basket >>>>>");
    }
}
