package BinarySearch;

import java.util.ArrayList;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last
 * integer of the previous row.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return 1 ( 1 corresponds to true )
 *
 * Return 0 / 1 ( 0 if the element is not present, 1 if the element is present )
 * for this problem
 *
 */
public class MatrixSearch {

    public static int searchInMatrixLinear(ArrayList<ArrayList<Integer>> mat, int num){
        int n = mat.size(), m = mat.get(0).size();
        int startX = 0, startY = m-1;

        while (startX < n && startY >= 0){
            int element = mat.get(startX).get(startY);
            if (element == num)
                return 1;
            else if(element > num)
                --startY;
            else
                ++startX;
        }

        return 0;
    }

    public static int searchInMatrixBinary(ArrayList<ArrayList<Integer>> mat, int num){
        int n = mat.size(), m = mat.get(0).size();
        int startRow = 0, endRow = n - 1;

        while (startRow < endRow){
            int mid = (startRow + endRow) / 2;
            int element = mat.get(mid).get(0);
            if (element == num) return 1;
            else if (element < mid) endRow = mid - 1;
            else startRow = mid + 1;
        }

        // start will give the correct row to find
        int startCol = 0, endCol = m - 1;

        while (startCol < endCol){
            int mid = (startCol + endCol) / 2;
            int element = mat.get(startRow).get(mid);
            if (element == num) return 1;
            else if (element < mid) endCol = mid - 1;
            else startCol = mid + 1;
        }
        return 0;
    }


}
