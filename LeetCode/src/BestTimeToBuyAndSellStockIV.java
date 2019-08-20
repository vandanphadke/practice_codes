/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock
 * before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // OPTIMIZATION //
        // Here we can maximize the number of transactions without actually thinking
        // about optimizing since there can be a max of (n/2) transactions. Since we
        // are given more than that, we just need to make sure that we are selling at a
        // higher price than what we bought it for.
        if (k >=  n/2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i-1])
                    maxPro += prices[i] - prices[i-1];
            }
            return maxPro;
        }

        int[][] dp = new int[k+1][n];
        for (int transactions = 1; transactions <= k; ++transactions){
            for (int i = 1; i < n; ++i){
                int currentMax = 0;
                for (int j = 0; j < i; ++j){
                    currentMax = Math.max(currentMax,
                            prices[i] - prices[j] + dp[transactions - 1][j]);
                    dp[transactions][i] = Math.max(dp[transactions][i-1], currentMax);
                }
            }
        }
        return dp[k][n-1];
    }
}
