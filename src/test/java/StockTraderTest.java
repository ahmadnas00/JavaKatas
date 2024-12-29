import katas.exercises.SemanticVersionComparator;
import katas.exercises.StockTrader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StockTraderTest {

    @Test
    public void StockTradertest(){

        int[] stockPrices1 = {7, 1, 5, 3, 6, 4};
        int[] stockPrices2 = {1, 1, 5, 3, 6, 7};
        int[] stockPrices3 = {2, 1, 9, 3, 6, 4};
        int[] stockPrices4 = {10, 11, 12, 1, 6, 4};
        int[] stockPrices5 = {10, 10, 10, 10, 10, 10};
        int[] stockPrices6 = {};
        assertEquals(5 , StockTrader.maxProfit(stockPrices1));
        assertEquals(6 , StockTrader.maxProfit(stockPrices2));
        assertEquals(8 , StockTrader.maxProfit(stockPrices3));
        assertEquals(5 , StockTrader.maxProfit(stockPrices4));
        assertEquals(0 , StockTrader.maxProfit(stockPrices5));
        assertEquals(0 , StockTrader.maxProfit(stockPrices6));

    }

    @Test
    public void StockTradertestnull(){
        assertThrows(IllegalArgumentException.class, () -> StockTrader.maxProfit(null));
    }


}
