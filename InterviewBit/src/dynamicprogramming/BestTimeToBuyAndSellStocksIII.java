package dynamicprogramming;

import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell
 * the stock before you buy again).
 *
 * Example :
 *
 * Input : [1 2 1 2]
 * Output : 2
 *
 * Explanation :
 *   Day 1 : Buy
 *   Day 2 : Sell
 *   Day 3 : Buy
 *   Day 4 : Sell
 */
public class BestTimeToBuyAndSellStocksIII {
    public static int getMaxProfit(List<Integer> prices){
        int n = prices.size();

        // Calculate the maximum profit that could have been before this particular
        // day.
        int[] leftProfit = new int[n];
        int min = prices.get(0);
        for (int i = 1; i < prices.size(); ++i){
            min = Math.min(min, prices.get(i));
            leftProfit[i] = Math.max(leftProfit[i-1], prices.get(i) - min);
        }

        // Calculate the maximum profit that could have been after this particular
        // day.
        int[] rightProfit = new int[n];
        int max = prices.get(n-1);
        for (int i = n - 2; i >= 0; --i){
            max = Math.max(prices.get(i), max);
            rightProfit[i] = Math.max(rightProfit[i+1], max - prices.get(i));
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i){
            maxProfit = Math.max(leftProfit[i] + rightProfit[i], maxProfit);
        }
        return maxProfit;
    }
}
