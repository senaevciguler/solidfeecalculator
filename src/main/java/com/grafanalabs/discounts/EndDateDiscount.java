package com.grafanalabs.discounts;

import java.time.LocalDate;

public class EndDateDiscount {

    public static final int BUY_NOW_DISCOUNT = 10;

    public static int discount(LocalDate itemEndDate) {
        if (itemEndDate.compareTo(LocalDate.now()) == 0) {
            return BUY_NOW_DISCOUNT;
        }
        return 0;
    }
}
