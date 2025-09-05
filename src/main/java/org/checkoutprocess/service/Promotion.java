package org.checkoutprocess.service;

import org.checkoutprocess.model.Item;

import java.util.List;

public interface Promotion {
    int applyPromotion(List<Item> items);

}
