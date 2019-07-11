package dynamicprogramming;

import java.util.Arrays;

/**
 *
 * Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
 *
 * Since the answer can be large, output answer modulo 1000000007
 *
 * N = 2, S = 4
 * Valid numbers are {22, 31, 13, 40}
 * Hence output 4.
 *
 */
public class NDigitNumbersWithSum {

    public static void main(String[] args){
        getWays(3, 6);
    }


    public static int getWays(int N, int S){
        int MOD = 1000000007;
        if(S < 1 || S > 9*N) return 0;

        int[][] dp = new int[N][S];
        for (int i = 0; i < S; ++i){
            if (i + 1 <= 9)
                dp[0][i] = 1;
            else
                dp[0][i] = 0;
        }

        for (int i = 0; i < N; ++i)
            dp[i][0] = 1;

        for (int i = 1; i < N; ++i){
            for (int j = 1; j < S; ++j){
                dp[i][j] = 0;
                for (int k = 0; k <=9; ++k){
                    if (j - k >= 0)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }
        }

        return dp[N-1][S-1];
    }
}
