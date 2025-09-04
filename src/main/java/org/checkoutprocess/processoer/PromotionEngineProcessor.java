package org.checkoutprocess.processoer;

import org.apache.commons.lang3.ObjectUtils;
import org.checkoutprocess.Exception.PromotionException;
import org.checkoutprocess.model.Item;
import org.checkoutprocess.service.BasePromotionLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * It calculates the final checkout total for a cart
 */
public class PromotionEngineProcessor {
    private final List<BasePromotionLevel> promotionLevels = new ArrayList<>();

    //Dynamically adding Promotions
    public void addPromotion(BasePromotionLevel promotionLevel) throws PromotionException {
        if (promotionLevel == null) {
            throw new PromotionException("Promotion can't be null");
        }

        promotionLevels.add(promotionLevel);
    }

    /**
     * Applies all Promotions and returns final total
     *
     * @param items
     * @return
     * @throws PromotionException
     */
    public int calculateTotal(List<Item> items) throws PromotionException {
        if (ObjectUtils.isEmpty(items)) {
            throw new PromotionException("items is Empty in the cart");
        }

        int total = 0;

        //After each Promotion layer
        for (BasePromotionLevel promotionLevel : promotionLevels) {
            total += promotionLevel.applyPromotion(items);
        }

        //add any leftover items
        for (Item item : items) {
            if (item.getQuantity() > 0) {
                total += item.getQuantity() * item.getProduct().getPrice();
                item.setQuantity(0);
            }
        }

        return total;

    }
}
