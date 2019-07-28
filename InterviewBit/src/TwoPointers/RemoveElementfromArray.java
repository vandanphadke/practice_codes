package TwoPointers;

import java.util.Arrays;
import java.util.List;

/**
 * Remove Element
 *
 * Given an array and a value, remove all the instances of that value in the array.
 * Also return the number of elements left in the array after the operation.
 * It does not matter what is left beyond the expected length.
 *
 *  Example:
 * If array A is [4, 1, 1, 2, 1, 3]
 * and value elem is 1,
 * then new length is 3, and A is now [4, 2, 3]
 * Try to do it in less than linear additional space complexity.
 */
public class RemoveElementfromArray {
    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(4, 1, 1, 2, 1, 3);
        removeElementFromArray(arr, 1);
    }

    public static int removeElementFromArray(List<Integer> arr, int num){
        int i = 0;
        int j = 0;

        while (i<arr.size()) {
            if (arr.get(i) != num) {
                if (i != j) {
                    arr.set(j, arr.get(i));
                    arr.set(i, num);
                }
                j++;
            }
            i++;
            System.out.println(arr);
            System.out.println(i + "  " + j);
        }

        return j;
    }
}
