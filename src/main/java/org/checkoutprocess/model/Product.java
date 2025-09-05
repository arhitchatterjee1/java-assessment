package org.checkoutprocess.model;

/**
 * indicates the product of the item
 */
public class Product {
    private double price; //defines the Price of the Product
    private String sku; //defines the skus of the product

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", sku='" + sku + '\'' +
                '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }


    public Product(double price, String sku) {
        this.price = price;
        this.sku = sku;
    }

    public Product() {
    }
}
