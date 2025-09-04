package org.checkoutprocess.promotionservice;

import org.checkoutprocess.model.Item;

import java.util.List;

@FunctionalInterface
public interface BasePromotionLevel {
    int applyPromotion(List<Item> items);
}
