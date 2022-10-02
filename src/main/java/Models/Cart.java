package Models;

import java.util.List;

public class Cart {

    private final List<Product> products;
    private final double totalCost;

    public Cart(List<Product> products, double totalCost) {
        this.products = products;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                ", totalCost=" + totalCost +
                '}';
    }
}
