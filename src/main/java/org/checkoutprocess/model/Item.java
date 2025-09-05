package org.checkoutprocess.model;

/**
 * It links a Product with its quantity in the shopping cart
 */
public class Item {
    private Product product; //defines product
    private int quantity; //defines the quantity of the Product
    private int unitPrice; // defines the unit level price of the product
    private int totalPrice; // defines the total price of the product

    public Item(int quantity, Product product, int unitPrice, int totalPrice) {
        this.quantity = quantity;
        this.product = product;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Item() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
