package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array of integers, find the starting and
 * ending position of a given target value.
 *
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example:
 * Given [5, 7, 7, 8, 8, 10]
 * and target value 8,
 * return [3, 4].
 */
public class RangeSearch {

    public static List<Integer> searchForRange(List<Integer> arr, int num){
        List<Integer> results = new ArrayList<>();
        results.add(first(arr, 0, arr.size() - 1, num));
        results.add(last(arr, 0, arr.size() - 1, num));
        return results;
    }

    public static int first(List<Integer> arr, int low, int high, int x)
    {
        if(high >= low)
        {
            int mid = low + (high - low)/2;
            if( ( mid == 0 || x > arr.get(mid-1)) && arr.get(mid) == x)
                return mid;
            else if(x > arr.get(mid))
                return first(arr, (mid + 1), high, x);
            else
                return first(arr, low, (mid -1), x);
        }
        return -1;
    }

    public static int last(List<Integer> arr, int low, int high, int x)
    {
        if(high >= low)
        {
            int mid = low + (high - low)/2;
            if( ( mid == arr.size()-1 || x < arr.get(mid+1)) && arr.get(mid) == x)
                return mid;
            else if(x < arr.get(mid))
                return last(arr, low, (mid -1), x);
            else
                return last(arr, (mid + 1), high, x);
        }
        return -1;
    }


}
