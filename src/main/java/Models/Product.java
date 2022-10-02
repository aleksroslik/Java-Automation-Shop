package Models;

import org.apache.commons.math3.util.Precision;

public class Product {

    private String name;
    private double quantityPrice;
    private int quantity;
    private double totalPrice;

    public Product(String name, double quantityPrice, int quantity, double totalPrice) {
        this.name = name;
        this.quantityPrice = Precision.round(quantityPrice, 2);
        this.quantity = quantity;
        this.totalPrice = totalPrice;
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

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = Precision.round(totalPrice, 2);
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
                ", totalPrice=" + totalPrice +
                '}';
    }
    public double getTotalPrice() {
        return Precision.round(quantityPrice*quantity, 2);
    }

    public static class ProductBuilder {
        private String name;
        private double quantityPrice;
        private int quantity;
        private double totalPrice;

        public ProductBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder quantityPrice(double quantityPrice) {
            this.quantityPrice = Precision.round(quantityPrice, 2);
            return this;
        }

        public ProductBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Product build() {
            return new Product(name, quantityPrice, quantity, totalPrice);
        }
    }
}
