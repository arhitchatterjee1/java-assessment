package org.checkoutprocess.service;

import org.checkoutprocess.model.Item;

import java.util.List;

/*
    A combinational Promotion will give special price when tow different skus are brought together
 */
public class MultipleLinePromotionPrice implements Promotion {
    private final String sku1;
    private final String sku2;
    private final double comboPrice;

    public MultipleLinePromotionPrice(String sku1, String sku2, int comboPrice) {
        this.sku1 = sku1;
        this.sku2 = sku2;
        this.comboPrice = comboPrice;
    }

    /**
     * A combinational Promotion will give special price when tow different skus are brought together
     * <p>
     * formula => minimum value between quantityOfSku1 and quantityOfsku2
     * total = (pairs * comboPrice) + (quantityOfSku1 - pairs) * pairsOfSku1 + ((quantityOfSku2 -pairs)* pairsOfSku2)
     *
     * @param items defines the list of the items
     * @return total number of skus
     */
    @Override
    public int applyPromotion(List<Item> items) {
        Item item1 = null, item2 = null;

        int total = 0;
        for (Item item : items) {

            if (item.getProduct().getSku().equals(sku1)) {
                item1 = item;
            }
            if (item.getProduct().getSku().equals(sku2)) {
                item2 = item;
            }
        }

        //check if both items are in stock
        if (item1 != null && item2 != null) {
            //calculate the number of pairs
            int pairsOfItem = (int) Math.min(item1.getQuantity(), item2.getQuantity());

            total += pairsOfItem * comboPrice;

            item1.setQuantity(item1.getQuantity() - pairsOfItem);

            item2.setQuantity(item2.getQuantity() - pairsOfItem);
        }


        return total;
    }
}
