package katas.exercises;

public class StockTrader2 {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock MULTIPLE times.
     *
     * O(n) is the best complexity
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {
        if ( prices == null ){
            throw new IllegalArgumentException("Can't be null");
        }
        int profit  = 0 ;


        for ( int i=1 ; i < prices.length ; i++){
            if ( prices[i] > prices[i-1]){
                profit = profit + (prices[i] - prices[i-1]) ;
            }

        }

        return profit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 7
    }
}
