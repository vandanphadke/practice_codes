package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, find the length of longest
 * subsequence which is first increasing then decreasing.
 *
 * **Example: **
 *
 * For the given array [1 11 2 10 4 5 2 1]
 *
 * Longest subsequence is [1 2 10 4 2 1]
 *
 * Return value 6
 */

public class LengthLongestSub {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(11);arr.add(2);arr.add(10);
        arr.add(4);arr.add(5);arr.add(2);arr.add(1);
        System.out.println(getlength(arr));
    }


    public static int getlength(List<Integer> arr){
        int n = arr.size();
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; ++i){
            for (int j = 0; j < i; ++j){
                if (arr.get(i) > arr.get(j))
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }

        int[] lds = new int[n];
        Arrays.fill(lds, 1);

        for (int i = n - 2; i >= 0; --i){
            for (int j = n - 1; j > i; --j){
                if (arr.get(i) > arr.get(j))
                    lds[i] = Math.max(lds[i], lds[j] + 1);
            }
        }

        int maxSequence = Integer.MIN_VALUE;
        for (int i = 0 ; i < n; ++i){
            maxSequence = Math.max(maxSequence, lis[i] + lds[i] - 1);
        }

        return maxSequence;
    }

}
