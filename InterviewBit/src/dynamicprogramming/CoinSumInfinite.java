package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite
 * amount of each coin in the set.
 *
 * Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).
 *
 * Example :
 *
 * Input :
 * 	S = [1, 2, 3]
 * 	N = 4
 *
 * Return : 4
 *
 * Explanation : The 4 possible ways are
 * {1, 1, 1, 1}
 * {1, 1, 2}
 * {2, 2}
 * {1, 3}
 * Note that the answer can overflow. So, give us the answer % 1000007
 */
public class CoinSumInfinite {
    public static void main(String[] args){
        System.out.println(getMaxWays(Arrays.asList(1, 2, 3), 4));
    }

    public static int getMaxWays(List<Integer> coins, int N){
        int[] dp = new int[N+1];
        dp[0] = 1;
        for (int i = 0; i < coins.size(); ++i)
            for (int j = coins.get(i); j <= N; ++j)
                dp[j] += dp[j-coins.get(i)];
        return dp[N];
    }
}
