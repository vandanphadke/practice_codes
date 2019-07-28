package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the longest increasing subsequence of a given sequence / array.
 *
 * In other words, find a subsequence of array in which the subsequence’s
 * elements are in strictly increasing order, and in which the subsequence
 * is as long as possible.
 * This subsequence is not necessarily contiguous, or unique.
 * In this case, we only care about the length of the longest increasing subsequence.
 *
 * Example :
 *
 * Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 * Output : 6
 * The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class LIS {
    public static int LIS(List<Integer> arr) {
        int[] L = new int[arr.size()];

        Arrays.fill(L, 1);

        for(int i = 0 ; i < arr.size() ; i++){
            for(int j = 0 ; j < i ; j++)
            {
                if(arr.get(i) > arr.get(j) && L[i] < L[j] + 1)
                {
                    L[i] = L[j] + 1 ;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; ++i){
            max = Math.max(L[i], max);
        }
        return max;
    }
}
