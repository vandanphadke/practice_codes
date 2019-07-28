package dynamicprogramming;

import java.util.List;

/**
 * Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the
 * largest rectangle inside the grid such that all the cells inside the chosen rectangle
 * should have 1 in them. You are allowed to permutate the columns matrix i.e. you can arrange
 * each of the column in any order in the final grid. Please follow the below example for
 * more clarity.
 *
 * Lets say we are given a binary grid of 3 * 3 size.
 *
 * 1 0 1
 *
 * 0 1 0
 *
 * 1 0 0
 *
 * At present we can see that max rectangle satisfying the criteria mentioned in the problem
 * is of 1 * 1 = 1 area i.e either of the 4 cells which contain 1 in it. Now since we are
 * allowed to permutate the columns of the given matrix, we can take column 1 and column 3
 * and make them neighbours. One of the possible configuration of the grid can be:
 *
 * 1 1 0
 *
 * 0 0 1
 *
 * 1 0 0
 *
 * Now In this grid, first column is column 1, second column is column 3 and third column is
 * column 2 from the original given grid. Now, we can see that if we calculate the max area
 * rectangle, we get max area as 1 * 2 = 2 which is bigger than the earlier case.
 * Hence 2 will be the answer in this case.
 */
public class LargestRectAreaPermutations {
    // TODO once again
    public static int getLargestRectangleArea(List<List<Integer>> arr){
        int m = arr.size(), n = arr.get(0).size();
        int[][] consecutive = new int[m][n];
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                if (i == 0)
                    consecutive[i][j] = arr.get(i).get(j);
                else if (arr.get(i).get(j) == 0)
                    consecutive[i][j] = 0;
                else
                    consecutive[i][j] = 1 + consecutive[i-1][j];
            }
        }

        for (int i = 0; i < m; i++) {
            int count[] = new int[m + 1];
            for (int j = 0; j < n; j++) {
                count[consecutive[i][j]]++;
            }
            int col_no = 0;
            for (int j = m; j >= 0; j--) {
                if (count[j] > 0) {
                    for (int k = 0; k < count[j]; k++) {
                        consecutive[i][col_no] = j;
                        col_no++;
                    }
                }
            }
        }

        int curr_area, max_area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curr_area = (j + 1) * consecutive[i][j];
                if (curr_area > max_area) {
                    max_area = curr_area;
                }
            }
        }
        return max_area;
    }
}
