package org.checkoutprocess;


import org.checkoutprocess.Exception.PromotionException;
import org.checkoutprocess.model.Item;
import org.checkoutprocess.model.Product;
import org.checkoutprocess.processoer.PromotionEngineProcessor;
import org.checkoutprocess.service.MultipleLinePromotionPrice;
import org.checkoutprocess.service.SingleLinePromotionPrice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Main Class for Running The Program
 */
public class PromotionEngineService {

    public static void main(String[] args) throws PromotionException {
        Scanner scanner = new Scanner(System.in);

        List<Product> products = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        // scan the products
        System.out.println("Enter the numbers of products");
        int productCount = scanner.nextInt();

        for (int productItr = 1; productItr <= productCount; productItr++) {
            System.out.println("Enter Product Name");
            String productName = scanner.next();

            System.out.println("Enter the price of " + productName + " the product");
            int price = scanner.nextInt();

            products.add(new Product(price, productName));

        }

        //scan the cart items
        for (Product product : products) {
            System.out.println("how many products " + product.getSku() + " are there?");
            int qty = scanner.nextInt();
            if (qty > 0) {
                items.add(new Item(product, qty));
            }
        }

        PromotionEngineProcessor promotionEngineProcessor = new PromotionEngineProcessor();

        promotionEngineProcessor.addPromotion(new SingleLinePromotionPrice("A", 3, 130));
        promotionEngineProcessor.addPromotion(new SingleLinePromotionPrice("B", 2, 45));
        promotionEngineProcessor.addPromotion(new MultipleLinePromotionPrice("C", "D", 30));

        //calculate total
        double total = promotionEngineProcessor.calculateTotal(items);

        System.out.println("final total Price: " + total);
    }


}
