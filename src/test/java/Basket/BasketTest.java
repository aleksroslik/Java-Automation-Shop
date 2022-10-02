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
    @DisplayName("Add random products and clear basket test")
    public void addRandomProductsAndClearBasket() {
        logger.info(">>>> Start test add random products to Basket >>>>>");

        List<Product> products = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            productGrid.openRandomProduct();
            productDetailsPage.setRandomQuantity()
                              .addToCart();
            addProductsToActualList(products);
            cartPopupPage.continueShopping();
            mainMenu.goToMainPage();
        }
        Cart actualCart =
                new Cart(products, Precision.round(products.stream().mapToDouble(Product::getTotalPrice).sum(), 2));
        logger.info("Actual cart: " + actualCart.toString());

        header.goToCart();

        Cart expectedCart = shoppingCartPage.getShoppingCart();
        logger.info("Expected cart: " + expectedCart.toString());

        Assertions.assertThat(actualCart)
                .usingRecursiveComparison().isEqualTo(expectedCart);

        removeItemsOneByOneAndCompare(products);

        String emptyBasket = shoppingCartPage.getEmptyBasketText();
        assertThat(emptyBasket).isEqualTo("There are no more items in your cart");

        logger.info(">>>> End test add random products to Basket >>>>>");
    }

    private void addProductsToActualList(List<Product> list) {
        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.getProductInfo(cartPopupPage);

        boolean alreadyInBasket = false;
        for (Product p : list) {
            if (p.getName().equals(product.getName())) {
                alreadyInBasket = true;
                p.setQuantity(product.getQuantity());
                p.setQuantityPrice(product.getQuantityPrice());
                p.setTotalPrice(product.getTotalPrice());
                break;
            }
        }
        if (!alreadyInBasket) {
            list.add(product);
        }
    }

    private void removeItemsOneByOneAndCompare(List<Product> list) {
        while(!list.isEmpty()) {
            Product item = list.get(0);
            list.remove(item);
            Cart actualCartAfterItemRemoval =
                    new Cart(list, Precision.round(list.stream().mapToDouble(Product::getTotalPrice).sum(), 2));
            shoppingCartPage.removeItem();
            logger.info("Actual cart after removing item: " + actualCartAfterItemRemoval.toString());
            Cart expectedCartAfterItemRemoval = shoppingCartPage.getShoppingCart();
            logger.info("Expected cart after removing item: " + expectedCartAfterItemRemoval.toString());
            Assertions.assertThat(actualCartAfterItemRemoval)
                    .usingRecursiveComparison().isEqualTo(expectedCartAfterItemRemoval);
        }
    }
}
