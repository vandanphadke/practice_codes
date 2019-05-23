/**
 * Given two words word1 and word2, find the minimum number of
 * steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea"
 * to "ea" and another step to make "eat" to "ea".
 *
 */
public class DeleteOperations {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= l2; ++i)
            dp[0][i] = i;
        for (int i = 1; i <= l1; ++i)
            dp[i][0] = i;


        for (int i = 1; i <= l1; ++i){
            for (int j = 1; j <= l2; ++j){
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[l1][l2];

    }
}
