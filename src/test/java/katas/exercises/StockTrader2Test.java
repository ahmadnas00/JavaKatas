package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StockTrader2Test {

    @Test
    public void StockTrader2test(){

        int[] stockPrices1 = {7, 1, 5, 3, 6, 4};
        int[] stockPrices2 = {1, 1, 5, 3, 6, 7};
        int[] stockPrices3 = {2, 1, 9, 3, 6, 4};
        int[] stockPrices4 = {10, 11, 12, 1, 6, 4};
        int[] stockPrices5 = {10, 10, 10, 10, 10, 10};
        int[] stockPrices6 = {};
        assertEquals(7 , StockTrader2.maxProfit(stockPrices1));
        assertEquals(8 , StockTrader2.maxProfit(stockPrices2));
        assertEquals(11 , StockTrader2.maxProfit(stockPrices3));
        assertEquals(7 , StockTrader2.maxProfit(stockPrices4));
        assertEquals(0 , StockTrader2.maxProfit(stockPrices5));
        assertEquals(0 , StockTrader2.maxProfit(stockPrices6));
    }

    @Test
    public void StockTrader2testnull(){
        assertThrows(IllegalArgumentException.class, () -> StockTrader2.maxProfit(null));
    }


}
