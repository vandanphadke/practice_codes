package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix M of size nxm and an integer K, find the maximum element in the K
 * manhattan distance neighbourhood for all elements in nxm matrix.
 * In other words, for every element M[i][j] find the maximum element M[p][q] such that
 * abs(i-p)+abs(j-q) <= K.
 *
 * Note: Expected time complexity is O(N*N*K)
 *
 * Constraints:
 *
 * 1 <= n <= 300
 * 1 <= m <= 300
 * 1 <= K <= 300
 * 0 <= M[i][j] <= 1000
 * Example:
 *
 * Input:
 * M  = [[1,2,4],[4,5,8]] , K = 2
 *
 * Output:
 * ans = [[5,8,8],[8,8,8]]
 */
public class KthManhattanDistanceNeighbourhood {
    public ArrayList<ArrayList<Integer>> getNeighourhood(List<List<Integer>> arr, int k){
        int n = arr.size(), m = arr.get(0).size();
        int[][][] dp = new int[k+1][n][m];
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                dp[0][i][j] = arr.get(i).get(j);
            }
        }
        for (int dist = 1; dist <= k; ++dist){
            for (int i = 0; i < n; ++i){
                for (int j = 0; j < m; ++j){
                    int max = Integer.MIN_VALUE;
                    if (i != 0)
                        max = Math.max(max, dp[dist-1][i-1][j]);
                    if (j != 0)
                        max = Math.max(max, dp[dist-1][i][j-1]);
                    if (i != n-1)
                        max = Math.max(max, dp[dist-1][i+1][j]);
                    if (j != m-1)
                        max = Math.max(max, dp[dist-1][i][j+1]);
                    dp[dist][i][j] = Math.max(max, dp[dist-1][i][j]);
                }
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            ArrayList<Integer> res = new ArrayList<>();
            for (int j = 0; j < m; ++j){
                res.add(dp[k][i][j]);
            }
            result.add(res);
        }
        return result;
    }
}
