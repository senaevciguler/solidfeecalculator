package com.grafanalabs.factory.impl;

import com.grafanalabs.discounts.EndDateDiscount;
import com.grafanalabs.enums.ItemType;
import com.grafanalabs.enums.UserType;
import com.grafanalabs.exception.GrafanaException;
import com.grafanalabs.factory.UserProcessor;

import java.time.LocalDate;

import static com.grafanalabs.discounts.EndDateDiscount.BUY_NOW_DISCOUNT;
import static com.grafanalabs.enums.ItemType.AUCTION;
import static com.grafanalabs.enums.ItemType.BUY_IT_NOW;
import static com.grafanalabs.enums.UserType.NORMAL;

public class NormalUser implements UserProcessor {

    @Override
    public int calculate(ItemType itemType, int itemPrice, LocalDate itemEndDate) {
        if (itemType == AUCTION) { //Auction
            return itemPrice + 25 - EndDateDiscount.discount(itemEndDate);
        } else if (itemType == BUY_IT_NOW) { //BuyItNow
            return itemPrice + 35 - BUY_NOW_DISCOUNT;
        } else {
            throw new GrafanaException("Unsupported item type");
        }
    }

    @Override
    public UserType getType() {
        return NORMAL;
    }
}
