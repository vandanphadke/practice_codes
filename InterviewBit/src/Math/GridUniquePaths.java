package Math;

/**
 * A robot is located at the top-left corner of an A x B grid (marked
 * ‘Start’ in the diagram below).
 *
 * Path Sum: Example 1
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
 *
 * How many possible unique paths are there?
 *
 * Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.
 *
 * Example :
 *
 * Input : A = 2, B = 2
 * Output : 2
 *
 * 2 possible routes : (0, 0) -> (0, 1) -> (1, 1)
 *               OR  : (0, 0) -> (1, 0) -> (1, 1)
 */
public class GridUniquePaths {
    public static int getNumWays(int m, int n){
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; ++i)
            dp[i][0] = 1;

        for (int i = 0; i < n; ++i)
            dp[0][n] = 1;

        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
