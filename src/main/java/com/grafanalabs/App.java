package com.grafanalabs;

import com.grafanalabs.exception.GrafanaException;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SolidFeeCalculator
 */
public class App {
    public static void main(String[] args) {
        int fee;
        try {
            fee = calculateFee(1, 0, 100, LocalDate.now());
        } catch (Exception exception) {
            throw new GrafanaException("something went wrong");
        }

        Logger logger
                = Logger.getLogger(
                App.class.getName());
        if (logger.isLoggable(Level.INFO))
            logger.info("calculate is:" + fee);
    }

    /**
     * This function handles all calculation you ever need!
     *
     * @param usertype    0= Normal, 1 = Company
     * @param itemType    0= Auction, 1 = BuyItNow
     * @param itemPrice   item price int=0
     * @param itemEndDate Item ends
     * @return calculated fee
     */

    public static int calculateFee(int usertype, int itemType, int itemPrice, LocalDate itemEndDate) {
        try {
            switch (usertype) {
                case 0: //Normal
                    //region Normal user
                    if (itemType == 0) { //Auction
                        int endDateDiscount = 0;
                        if (itemEndDate.compareTo(LocalDate.now()) == 0) endDateDiscount = 10;

                        return itemPrice + 25 - endDateDiscount;
                    } else if (itemType == 1) { //BuyItNow
                        int buyItNowDiscount = 10;
                        return itemPrice + 35 - buyItNowDiscount;
                    }
                    break;
                //endregion
                case 1: //Company
                    //region Company
                    if (itemType == 0) { //Auction
                        if (itemEndDate.equals(LocalDate.now())) {
                            return itemPrice + 25 - 15;// EndDate discount and company discount
                        }
                        return itemPrice + 25 - 5;// Only company discount
                    } else if (itemType == 1) { //BuyItNow
                        return itemPrice + 35 - 15;
                    }
                    break;
                //endregion
                default:
            }
        } catch (Exception exception) {
            Logger logger
                    = Logger.getLogger(
                    App.class.getName());

            logger.log(Level.INFO, exception.getMessage());
        }
        return 0;
    }
}