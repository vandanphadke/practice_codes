package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a grid of size m * n, lets assume you are starting at (1,1)
 * and your goal is to reach (m,n). At any instance, if you are on (x,y),
 * you can either go to (x, y + 1) or (x + 1, y).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Example :
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 *  Note: m and n will be at most 100.
 */
public class UniquePathsInGrid {
    public static void main(String[] args){
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(0, 0, 0));
        arr.add(Arrays.asList(0, 1, 0));
        arr.add(Arrays.asList(0, 0, 0));
        System.out.println(getUniquePaths(arr));
    }

    public static int getUniquePaths(List<List<Integer>> paths){
        if (paths.get(0).get(0) == 1) return 0;
        int m = paths.size(), n = paths.get(0).size();
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        boolean flag = false;
        for (int i = 0; i < m; ++i){
            if (paths.get(i).get(0) == 1){
                flag = true;
            }
            if (!flag) dp[i][0] = 1;
            else dp[i][0] = 0;
        }

        flag = false;
        for (int i = 0; i < n; ++i){
            if (paths.get(0).get(i) == 1){
                flag = true;
            }
            if (!flag) dp[0][i] = 1;
            else dp[0][i] = 0;
        }


        for (int i = 1; i < m; ++i){
            for (int j = 1; j < n; ++j){
                if (paths.get(i).get(j) == 1){
                    dp[i][j] = 0;
                }
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
