package com.grafanalabs;

import com.grafanalabs.enums.ItemType;
import com.grafanalabs.enums.UserType;
import com.grafanalabs.exception.GrafanaException;
import com.grafanalabs.factory.UserFactory;

import java.time.LocalDate;
import java.util.logging.Logger;

import static com.grafanalabs.enums.ItemType.AUCTION;
import static com.grafanalabs.enums.UserType.COMPANY;

/**
 * SolidFeeCalculator
 */
public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        int fee;
        try {
            fee = calculateFee(COMPANY, AUCTION, 100, LocalDate.now());
        } catch (Exception exception) {
            throw new GrafanaException("something went wrong");
        }
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
    public static int calculateFee(UserType usertype, ItemType itemType, int itemPrice, LocalDate itemEndDate) {
        return new UserFactory().getUser(usertype)
                .calculate(itemType, itemPrice, itemEndDate);
    }
}