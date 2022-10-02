package Models;

import DataProviders.ProductFactory;
import PageObjects.Cart.CartPopupPage;
import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;
import java.util.List;

public class OrderList {

    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void addProductsToActualList(CartPopupPage cartPopupPage) {
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
    }

    public Cart getShoppingCart() {
        return new Cart(products, Precision.round(products.stream().mapToDouble(Product::getTotalPrice).sum(), 2));
    }

    public boolean isOrderListEmpty() {
        return products.isEmpty();
    }
}
