package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
 * adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 *  Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total
 * number of rows in the triangle.
 */
public class MinSumPathInTriangle {
    public static void main(String[] args){
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(2));
        arr.add(Arrays.asList(3, 4));
        arr.add(Arrays.asList(6, 5, 7));
        arr.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(getMinPath(arr));
    }


    public static int getMinPath(List<List<Integer>> arr){
        int n = arr.size();
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(arr.get(0)));
        for (int i = 1; i < n; ++i){
            List<Integer> dpRow = new ArrayList<>();
            for (int j = 0; j <= i; ++j){
                if (j == 0)
                    dpRow.add(arr.get(i).get(0) + dp.get(i-1).get(0));
                else if(j == i)
                    dpRow.add(arr.get(i).get(i) + dp.get(i-1).get(j-1));
                else
                    dpRow.add(arr.get(i).get(j) +
                            Math.min(dp.get(i-1).get(j-1), dp.get(i-1).get(j)));
            }
            dp.add(dpRow);
        }

        List<Integer> last = dp.get(dp.size() - 1);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < last.size(); ++i) {
            min = Math.min(min, last.get(i));
        }
        return min;
    }
}
