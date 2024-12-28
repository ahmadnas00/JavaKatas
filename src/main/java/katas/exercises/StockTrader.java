package katas.exercises;

public class StockTrader {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock ONCE.
     *
     * Aim for O(n)
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {
        if ( prices == null ){
            throw new IllegalArgumentException("Can't be null");
        }

        int minprice = Integer.MAX_VALUE;
        int maxprofit=0;

        for ( int i=0 ; i < prices.length ; i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }
            else if (prices[i] > minprice) {
                if ( (prices[i]-minprice)>maxprofit){
                    maxprofit = prices[i]-minprice;
                }
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 5
    }
}
