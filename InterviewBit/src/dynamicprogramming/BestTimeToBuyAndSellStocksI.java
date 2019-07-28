package dynamicprogramming;

import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one
 * share of the stock), design an algorithm to find the maximum profit.
 *
 * Example :
 *
 * Input : [1 2]
 * Return :  1
 */
public class BestTimeToBuyAndSellStocksI {

    public static int getMaxPrices(List<Integer> prices){
        if (prices == null || prices.size() == 0)
            return 0;

        int min = prices.get(0);
        int result = 0;
        for (int i = 0; i < prices.size(); ++i){
            if(result < prices.get(i) - min){
                result = prices.get(i) - min;
            }
            min = Math.min(min, prices.get(i));
        }
        return result;
    }
}
