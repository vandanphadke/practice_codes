package TwoPointers;

import java.util.List;

/**
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each
 * element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length,
 * make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in
 * place with constant memory.
 *
 *
 * Example:
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicates {

    public static int removeDuplicates(List<Integer> arr){
        if (arr == null || arr.size() == 0) return 0;

        int copyIndex = 1;

        for (int i = 1; i < arr.size(); ++i){
            if (arr.get(i) != arr.get(i - 1)){
                arr.set(copyIndex, arr.get(i));
                ++copyIndex;
            }
        }
        return copyIndex;
    }

}
