package DataProviders;

import Models.Product;
import PageObjects.Cart.CartPopupPage;

public class ProductFactory {

    public Product getProductInfo(CartPopupPage cartPopupPage) {

        String name = cartPopupPage.getProductName();
        double quantityPrice = cartPopupPage.getProductPrice();
        int quantity = cartPopupPage.getQuantity();

        return new Product.ProductBuilder()
                .setName(name)
                .setQuantityPrice(quantityPrice)
                .setQuantity(quantity)
                .build();
    }
}
