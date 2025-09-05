package org.checkoutprocess.service;

import org.checkoutprocess.model.Item;
import org.checkoutprocess.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndividualItemsPromotionTest {

    @Test
    void individualItemsPromotionTest_for_individualItems(){
        Product product = new Product(50,"A");
        Item item = new Item(product,2);
        List<Item> items = new ArrayList<>();
        items.add(item);

        SingleLinePromotionPrice promotion = new SingleLinePromotionPrice("A", 3, 130);
        int total = promotion.applyPromotion(items);

        assertEquals(100, total);

    }

    @Test
    void individualItemsPromotionTest_for_individualItems_With_ZeroQuantity(){
        Product product = new Product(50,"A");
        Item item = new Item(product,0);
        List<Item> items = new ArrayList<>();
        items.add(item);

        SingleLinePromotionPrice promotion = new SingleLinePromotionPrice("A", 3, 130);
        int total = promotion.applyPromotion(items);

        assertEquals(0, total);

    }

    @Test
    void individualItemsPromotionTest_for_individualItems_With_Promption(){
        Product product = new Product(50,"A");
        Item item = new Item(product,3);
        List<Item> items = new ArrayList<>();
        items.add(item);

        SingleLinePromotionPrice promotion = new SingleLinePromotionPrice("A", 3, 130);
        int total = promotion.applyPromotion(items);

        assertEquals(130, total);

    }


}