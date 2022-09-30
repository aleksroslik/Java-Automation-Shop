package Models;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Product {

    private String name;
    private double quantityPrice;
    private int quantity;

    public Product(String name, double quantityPrice, int quantity) {
        this.name = name;
        this.quantityPrice = quantityPrice;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", quantityPrice=" + quantityPrice +
                ", quantity=" + quantity +
                '}';
    }

    public double getTotalPrice() {
        return quantityPrice*quantity;
    }

    public static class ProductBuilder {
        private String name;
        private double quantityPrice;
        private int quantity;

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setQuantityPrice(double quantityPrice) {
            this.quantityPrice = quantityPrice;
            return this;
        }

        public ProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Product build() {
            return new Product(name, quantityPrice, quantity);
        }
    }
}