package Models;

import org.apache.commons.math3.util.Precision;

public class Product {

    private String name;
    private double quantityPrice;
    private int quantity;

    public Product(String name, double quantityPrice, int quantity) {
        this.name = name;
        this.quantityPrice = Precision.round(quantityPrice, 2);
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantityPrice() {
        return quantityPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityPrice(double quantityPrice) {
        this.quantityPrice = Precision.round(quantityPrice, 2);
    }

    public void setQuantity(int quantity) {
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
        return Precision.round(quantityPrice*quantity, 2);
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
            this.quantityPrice = Precision.round(quantityPrice, 2);
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
