package org.checkoutprocess.model;

public class Product {
    private int price;
    private String sku;

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", sku='" + sku + '\'' +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }



    public Product(int price, String sku) {
        this.price = price;
        this.sku = sku;
    }

    public Product() {
    }
}
