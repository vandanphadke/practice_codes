package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions
 * as you like (ie, buy one and sell one share of the stock multiple times). However,
 * you may not engage in multiple transactions at the same time (ie, you must sell the stock
 * before you buy again).
 *
 * Example :
 *
 * Input : [1 2 3]
 * Return : 2
 */
public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args){
        System.out.println(getMaxProfit(Arrays.asList(3, 2, 1)));
    }

    public static int getMaxProfit(List<Integer> prices){
        int i = 0, profit = 0, n = prices.size();
        int buy = 0, sell = 0;
        while (i < n - 1){
            while ((i < n - 1) && prices.get(i) >= prices.get(i+1))
                ++i;
            buy = prices.get(i);
            while ((i < n - 1) && prices.get(i) <= prices.get(i+1))
                ++i;
            sell = prices.get(i);
            profit += (sell - buy);
        }
        return profit;
    }
}
