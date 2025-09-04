package org.checkoutprocess.service;

import org.checkoutprocess.model.Item;

import java.util.List;

public interface BasePromotionLevel {
    int applyPromotion(List<Item> items);

}
