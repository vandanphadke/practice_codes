package Arrays;

import java.util.List;

/**
 * Given an array A of integers, find the maximum of j - i
 * subjected to the constraint of A[i] <= A[j].
 *
 * If there is no solution possible, return -1.
 *
 * Example :
 *
 * A : [3 5 4 2]
 *
 * Output : 2
 * for the pair (3, 4)
 *
 */
public class MaxDistance {

    public int getMaxDistanceArr(List<Integer> arr){

        int n = arr.size();
        int[] lMin = new int[n];
        int[] rMax = new int[n];

        lMin[0] = arr.get(0);
        rMax[n - 1] = arr.get(n-1);

        int currMin = arr.get(0);
        for (int i = 1; i < n; ++i){
            currMin = Math.min(currMin, arr.get(i));
            lMin[i] = currMin;
        }

        int currMax = arr.get(n-1);
        for (int i = n-2; i >= 0; --i){
            currMax = Math.max(currMax, arr.get(i));
            rMax[i] = currMax;
        }

        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;

        while (i < n && j < n){
            if (lMin[i] <= rMax[j]){
                max = Math.max(j - i, max);
                ++j;
            }
            else
                ++i;

        }

        return max;
    }

}
