package DataProviders;

import Models.Product;
import PageObjects.Cart.CartPopupPage;

public class ProductFactory {

    public Product getProductInfo(CartPopupPage cartPopupPage) {

        String name = cartPopupPage.getProductName();
        double quantityPrice = cartPopupPage.getProductPrice();
        int quantity = cartPopupPage.getQuantity();
        double totalPrice = cartPopupPage.getProductPrice()*cartPopupPage.getQuantity();

        return new Product.ProductBuilder()
                .name(name)
                .quantityPrice(quantityPrice)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();
    }
}
