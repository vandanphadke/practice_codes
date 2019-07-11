package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * There are N coins (Assume N is even) in a line. Two players take
 * turns to take a coin from one of the ends of the line until there
 * are no more coins left. The player with the larger amount of money
 * wins. Assume that you go first.
 *
 * Write a program which computes the maximum amount of money you can win.
 *
 * Example:
 *
 * suppose that there are 4 coins which have value
 * 1 2 3 4
 * now you are first so you pick 4
 * then in next term
 * next person picks 3 then
 * you pick 2 and
 * then next person picks 1
 * so total of your money is 4 + 2 = 6
 * next/opposite person will get 1 + 3 = 4
 * so maximum amount of value you can get is 6
 *
 */
public class CoinsInALine {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);arr.add(4);arr.add(5);
        System.out.println(getMaxValue(arr));
    }

    public static int getMaxValue(List<Integer> coins){
        int n = coins.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i){
            dp[i][i] = coins.get(i);
        }

        for (int i = 0; i < n - 1; ++i){
            dp[i][i+1] = Math.max(coins.get(i), coins.get(i+1));
        }


        for (int l = 3; l <= n; ++l){
            for (int i = 0; i < n - l + 1; ++i){
                int j = i + l - 1;
                dp[i][j] = Math.max(
                  coins.get(i) + Math.min(dp[i + 2][j], dp[i+1][j-1]),
                        coins.get(j) + Math.min(dp[i + 1][j - 1], dp[i][j-2])
                );
            }
        }

        return dp[0][n-1];
    }



}
