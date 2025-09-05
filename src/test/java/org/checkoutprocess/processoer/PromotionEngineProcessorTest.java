package org.checkoutprocess.processoer;

import com.sun.source.tree.AssertTree;
import org.checkoutprocess.Exception.PromotionException;
import org.checkoutprocess.model.Item;
import org.checkoutprocess.model.Product;
import org.checkoutprocess.service.CombinationalPromotionPerItems;
import org.checkoutprocess.service.IndividualItemsPromotion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PromotionEngineProcessorTest {
    private PromotionEngineProcessor promotionEngineProcessor;
    private List<Item> itemList;

    @BeforeEach
    void setup() throws PromotionException {
        promotionEngineProcessor = new PromotionEngineProcessor();
        itemList = new ArrayList<>();

        promotionEngineProcessor.addPromotion(new IndividualItemsPromotion("A", 3, 130));
        promotionEngineProcessor.addPromotion(new IndividualItemsPromotion("B", 2, 45));
        promotionEngineProcessor.addPromotion(new CombinationalPromotionPerItems("C", "D", 30));
    }

    @Test
    void PromotionEngineProcessorTest1() throws PromotionException {
        itemList.add(new Item(new Product(50, "A"), 1));
        itemList.add(new Item(new Product(30, "B"), 1));
        itemList.add(new Item(new Product(20, "C"), 1));

        int total = promotionEngineProcessor.calculateTotal(itemList);

        assertEquals(100, total);
    }

    @Test
    void PromotionEngineProcessorTest2() throws PromotionException {

        assertThrows(PromotionException.class, () -> promotionEngineProcessor.calculateTotal(null));

    }

    @Test
    void PromotionEngineProcessorTest3() throws PromotionException {

        assertThrows(PromotionException.class, () -> promotionEngineProcessor.addPromotion(null));

    }

}