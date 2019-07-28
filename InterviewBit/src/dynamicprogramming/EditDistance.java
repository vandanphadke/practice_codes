package dynamicprogramming;

/**
 * Given two words A and B, find the minimum number of steps required
 * to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example :
 * edit distance between
 * "Anshuman" and "Antihuman" is 2.
 *
 * Operation 1: Replace s with t.
 * Operation 2: Insert i.
 */
public class EditDistance {
    public int getEditDistance(String s1, String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; ++i){
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; ++i){
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; ++i){
            for (int j = 1; j <= n; ++j){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]),
                                            dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
