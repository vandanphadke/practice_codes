package dynamicprogramming;

import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest product.
 * Return an integer corresponding to the maximum product possible.
 *
 * Example :
 *
 * Input : [2, 3, -2, 4]
 * Return : 6
 *
 * Possible with [2, 3]
 */
public class MaximumProductSubarray {
    public int maxProduct(final List<Integer> arr) {
        int max = arr.get(0), min = arr.get(0), result = arr.get(0);
        for (int i = 1; i < arr.size(); ++i){
            if (arr.get(i) >= 0){
                max = Math.max(arr.get(i), max * arr.get(i));
                min = Math.min(arr.get(i), min * arr.get(i));
            }
            else {
                int temp = max;
                max = Math.max(arr.get(i), min * arr.get(i));
                min = Math.min(arr.get(i), temp * arr.get(i));
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
