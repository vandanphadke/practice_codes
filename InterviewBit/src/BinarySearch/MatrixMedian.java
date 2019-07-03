package BinarySearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given a N cross M matrix in which each row is sorted,
 * find the overall median of the matrix. Assume N*M is odd.
 *
 * For example,
 *
 * Matrix=
 *
 * [1, 3, 5]
 * [2, 6, 9]
 * [3, 6, 9]
 *
 * A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
 *
 * Median is 5. So, we return 5.
 *
 */
public class MatrixMedian {

    public static int getMatrixMedian(ArrayList<ArrayList<Integer>> mat){
        int matMin = Integer.MAX_VALUE, matMax = Integer.MIN_VALUE;
        int n = mat.size(), m = mat.get(0).size();
        int result = 0;

        // Get the maximum and minimum value from the matrix
        for (int i = 0; i < n; ++i){
            matMin = Math.min(matMin, mat.get(i).get(0));
            matMax = Math.max(matMax, mat.get(i).get(m - 1));
        }


        while (matMin < matMax){
            int mid = matMin + ((matMax  - matMin) / 2);
            int count = 0;
            for (int i = 0; i < n; ++i){
                count += getLessThanCountList(mat.get(i), mid);
            }
            if (count < ((n*m)/2 + 1))
                matMin = mid + 1;
            else{
                result = mid;
                matMax = mid - 1;
            }
        }

        return result;
    }

    // Counts the number of elements less than num in a sorted array
    public static int getLessThanCountList(ArrayList<Integer> arr, int num){
        int low = 0, high = arr.size() - 1;
        while (low <= high){
            int mid = low + ((high - low) / 2);
            if (arr.get(mid) > num) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

}
