package org.checkoutprocess.service;

import org.checkoutprocess.model.Item;

import java.util.List;

/*
 * It will apply a discount when a customer buys a certain number of the same sku
 */
public class SingleLinePromotionPrice implements Promotion {
    private final String sku;
    private final int requiredQty;
    private final int priceAfterPromotion;

    public SingleLinePromotionPrice(String sku, int requiredQty, int priceAfterPromotion) {
        this.sku = sku;
        this.requiredQty = requiredQty;
        this.priceAfterPromotion = priceAfterPromotion;
    }


    /**
     * This will apples a discount when a customer buys a certain number of the same sku
     * Formula => total = (quantity / requiredQty) * PromoPrice+(quantity % requiredQty) * unitPrice
     *
     * @param items defines the list of the items
     * @return total number of skus
     */

    @Override
    public int applyPromotion(List<Item> items) {
        int total = 0;
        for (Item item : items) {
            if (item.getProduct().getSku().equals(sku)) {

                int qty = item.getQuantity();
                int quantitySets = qty / requiredQty;
                int reminder = qty % requiredQty;

                total += quantitySets * priceAfterPromotion + reminder * item.getProduct().getPrice();

                item.setQuantity(0);

            }
        }
        return total;
    }
}
