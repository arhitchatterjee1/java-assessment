package org.checkoutprocess.processoer;

import org.checkoutprocess.Exception.PromotionException;
import org.checkoutprocess.model.Item;
import org.checkoutprocess.model.Product;
import org.checkoutprocess.service.MultipleLinePromotionPrice;
import org.checkoutprocess.service.SingleLinePromotionPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PromotionEngineProcessorTest {
    private PromotionEngineProcessor processor;
    private Product A, B, C, D;

    @BeforeEach
    void setup() throws PromotionException {
        processor = new PromotionEngineProcessor();

        //Define the Products

        A = new Product(50, "A");
        B = new Product(30, "B");
        C = new Product(20, "C");
        D = new Product(50, "D");

        // Adding Promotions

        processor.addPromotion(new SingleLinePromotionPrice("A", 3, 130));
        processor.addPromotion(new SingleLinePromotionPrice("B", 2, 45));
        processor.addPromotion(new MultipleLinePromotionPrice("C", "D", 30));

    }

    @Test
    void shouldCalculate_Total_ForSimpleCart() throws PromotionException {
        List<Item> items = new ArrayList<>();
        items.add(new Item(A, 1));
        items.add(new Item(B, 1));
        items.add(new Item(C, 1));

        double total = processor.calculateTotal(items);

        assertEquals(100, total);
    }

    @Test
    void shouldCalculate_Total_ForBulkPurchase() throws PromotionException {
        List<Item> items = new ArrayList<>();
        items.add(new Item(A, 5));
        items.add(new Item(B, 5));
        items.add(new Item(C, 1));

        double total = processor.calculateTotal(items);

        assertEquals(370, total);

    }

    @Test
    void shouldCalculate_Total_ForComboPurchase() throws PromotionException {
        List<Item> items = new ArrayList<>();
        items.add(new Item(A, 3));
        items.add(new Item(B, 5));
        items.add(new Item(C, 1));
        items.add(new Item(D, 1));

        double total = processor.calculateTotal(items);

        assertEquals(280, total);

    }

    @Test
    void PromotionEngineProcessorTest_for_ExceptionHandling_ForAddingTotal() throws PromotionException {

        assertThrows(PromotionException.class, () -> processor.calculateTotal(null));

    }

    @Test
    void PromotionEngineProcessorTest_forExceptionHandling_for_addingPromotion() throws PromotionException {

        assertThrows(PromotionException.class, () -> processor.addPromotion(null));

    }

}