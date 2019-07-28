package BinarySearch;

import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
 *
 * You are given a target value to search. If found in the array, return its index,
 * otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Input : [4 5 6 7 0 1 2] and target = 4
 * Output : 0
 *
 * NOTE : Think about the case when there are duplicates. Does your current
 * solution work? How does the time complexity change?
 */
public class RotatedSortedArraySearch {
    public int getIndex(List<Integer> arr, int element){
        int start = 0, end = arr.size() - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (arr.get(mid) == element){
                return mid;
            }
            if (arr.get(start) < arr.get(mid)){
                if (element >= arr.get(start) && element <= arr.get(mid)){
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (element >= arr.get(mid) && element <= arr.get(end)){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }

            }
        }
        return -1;
    }
}
