package Arrays;

import java.util.List;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example:
 *
 * Given [1,2,0] return 3,
 *
 * [3,4,-1,1] return 2,
 *
 * [-8, -7, -6] returns 1
 *
 * Your algorithm should run in O(n) time and use constant space.
 */
public class FirstMissingInteger {

    public int getFirstMissingInteger(List<Integer> arr){
        int n = arr.size();
        for (int i = 0; i < n; ++i){
            int element = arr.get(i);
            if (element <= 0 || element == (i+1) || element > n){
                continue;
            }
            else if (!arr.get(arr.get(i) - 1).equals(arr.get(i))){
                swapList(arr, i, arr.get(i) - 1);
            }
        }


        for (int i = 0; i < n; ++i){
            if (arr.get(i) != i + 1)
                return (i+1);
        }
        return n;
    }

    public void swapList(List<Integer> arr, int index1, int index2){
        int temp = arr.get(index1);
        arr.set(index1, arr.get(index2));
        arr.set(index2, temp);
    }


}
