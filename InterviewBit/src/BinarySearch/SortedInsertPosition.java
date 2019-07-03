package BinarySearch;

import java.util.List;

/**
 * Given a sorted array and a target value, return the index
 * if the target is found. If not, return the index where it
 * would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 *
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SortedInsertPosition {

    public static int getPosition(List<Integer> arr, int num){
        int low = 0, high = arr.size() - 1;
        boolean less = false;
        int mid = 0;
        while (low <= high){
            mid = low + (high - low)/2;
            if (arr.get(mid) == num) return mid;
            else if (arr.get(mid) < num){
                less = true;
                low = mid + 1;
            }
            else {
                less = false;
                high = mid - 1;
            }
        }

        if (less) ++mid;
        return mid;
    }


}
