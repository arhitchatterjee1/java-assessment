package org.checkoutprocess.service;

import org.checkoutprocess.model.Item;
import org.checkoutprocess.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationalPromotionPerItemsTest {

    @Test
    void combinationalPromotionTest1(){
        Product product1 = new Product(20,"C");
        Product product2 = new Product(15,"D");
        Item item1 = new Item(product1,1);
        Item item2 = new Item(product2,1);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        MultipleLinePromotionPrice combinationalPromotionPerItems = new MultipleLinePromotionPrice("C", "D", 30);

        int total = combinationalPromotionPerItems.applyPromotion(items);

        assertEquals(30, total);


    }


}