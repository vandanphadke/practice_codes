package TwoPointers;

import java.util.List;

/**
 * Remove Duplicates from Sorted Array
 *
 * Given a sorted array, remove the duplicates in place such that each element can appear
 * atmost twice and return the new length. Do not allocate extra space for another array,
 * you must do this in place with constant memory.Note that even though we want you to return
 * the new length, make sure to change the original array as well in place
 *
 * For example,
 * Given input array A = [1,1,1,2],
 *
 * Your function should return length = 3, and A is now [1,1,2].
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(List<Integer> arr){
        if (arr == null) return 0;
        if (arr.size() < 3) return arr.size();
        int i = 1, j = 2;
        while (j < arr.size()){
            if (arr.get(j) == arr.get(i) && arr.get(i) == arr.get(i-1)){
                ++j;
            }
            else {
                ++i;
                arr.set(i, arr.get(j));
                ++j;
            }
        }
        return i+1;
    }
}
