package dynamicprogramming;

/**
 *  Given a string, find if there is any sub-sequence that repeats itself.
 * A sub-sequence of a string is defined as a sequence of characters generated
 * by deleting some characters in the string without changing the order of the
 * remaining characters.
 *
 * Input:
 * string
 *
 * Output:
 *
 * 0/1
 * 0 -> No
 * 1 -> Yes
 * Example:
 *
 * abab ------> yes, ab is repeated. So, return 1.
 * abba ------> No, a and b follow different order. So, return 0.
 * NOTE : sub-sequence length should be greater than or equal to 2
 */
public class RepeatingSubSequence {
    public int checkRepeatingSubsequence(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                if (s1.charAt(i) == s2.charAt(j) && i != j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        if (dp[m-1][n-1] > 1){
            return 1;
        }
        return 0;
    }
}
