package com.grafanalabs;

import com.grafanalabs.enums.ItemType;
import com.grafanalabs.enums.UserType;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.time.LocalDate;

import static com.grafanalabs.enums.ItemType.AUCTION;
import static com.grafanalabs.enums.ItemType.BUY_IT_NOW;
import static com.grafanalabs.enums.UserType.COMPANY;
import static com.grafanalabs.enums.UserType.NORMAL;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        UserType userType = NORMAL;
        ItemType itemType = AUCTION;
        int itemPrice = 0;
        LocalDate itemEndDate = LocalDate.now();
        int expected = 15;
        int actual = App.calculateFee(userType, itemType, itemPrice, itemEndDate);
        assertEquals(expected, actual);
    }

    public void testCompanyAuctionNow() {
        //given
        int expected = 110;
        UserType userType = COMPANY;
        ItemType itemType = AUCTION;
        int itemPrice = 100;
        LocalDate itemEndDate = LocalDate.now();

        //when
        int actual = App.calculateFee(userType, itemType, itemPrice, itemEndDate);

        //then
        assertEquals(expected, actual);
    }

    public void testCompanyAuctionNotNow() {
        //given
        int expected = 120;
        UserType userType = COMPANY;
        ItemType itemType = AUCTION;
        int itemPrice = 100;
        LocalDate itemEndDate = LocalDate.now().minusDays(1);

        //when
        int actual = App.calculateFee(userType, itemType, itemPrice, itemEndDate);

        //then
        assertEquals(expected, actual);
    }

    public void testCompanyBuyItNow() {
        //given
        int expected = 110;
        UserType userType = COMPANY;
        ItemType itemType = BUY_IT_NOW;
        int itemPrice = 100;
        LocalDate itemEndDate = LocalDate.now();

        //when
        int actual = App.calculateFee(userType, itemType, itemPrice, itemEndDate);

        //then
        assertEquals(expected, actual);
    }

    public void testNormalAuctionNow() {
        //given
        int expected = 115;
        UserType userType = NORMAL;
        ItemType itemType = AUCTION;
        int itemPrice = 100;
        LocalDate itemEndDate = LocalDate.now();

        //when
        int actual = App.calculateFee(userType, itemType, itemPrice, itemEndDate);

        //then
        assertEquals(expected, actual);
    }
    public void testNormalAuctionNotNow() {
        //given
        int expected = 125;
        UserType userType = NORMAL;
        ItemType itemType = AUCTION;
        int itemPrice = 100;
        LocalDate itemEndDate = LocalDate.now().minusDays(1);

        //when
        int actual = App.calculateFee(userType, itemType, itemPrice, itemEndDate);

        //then
        assertEquals(expected, actual);
    }

    public void testNormalBuyItNow() {
        //given
        int expected = 115;
        UserType userType = NORMAL;
        ItemType itemType = BUY_IT_NOW;
        int itemPrice = 100;
        LocalDate itemEndDate = LocalDate.now();

        //when
        int actual = App.calculateFee(userType, itemType, itemPrice, itemEndDate);

        //then
        assertEquals(expected, actual);
    }

}
