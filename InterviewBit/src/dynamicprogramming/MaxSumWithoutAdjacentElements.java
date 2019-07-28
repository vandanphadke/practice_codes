package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
 * is maximum and no two chosen numbers are adjacent horizontally, vertically or
 * diagonally, and return it.
 *
 * Example:
 *
 * Grid:
 * 	1 2 3 4
 * 	2 3 4 5
 * so we will choose
 * 3 and 5 so sum will be 3 + 5 = 8
 */
public class MaxSumWithoutAdjacentElements {

    public static int getMaximumSum(ArrayList<ArrayList<Integer>> arr){
        int n = arr.get(0).size();
        int[] dp = new int[n];
        dp[0] = Math.max(arr.get(0).get(0), arr.get(1).get(0));
        if (n < 2) return dp[0];
        dp[1] = Math.max(arr.get(0).get(1), arr.get(1).get(1));
        dp[1] = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; ++i){
            dp[i] = Math.max(arr.get(0).get(i), arr.get(1).get(i));
            dp[i] = Math.max(dp[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}
