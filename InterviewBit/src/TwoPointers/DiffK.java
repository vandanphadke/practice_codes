package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array ‘A’ of sorted integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 *  Example: Input :
 *     A : [1 3 5]
 *     k : 4
 *  Output : YES as 5 - 1 = 4
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Try doing this in less than linear space complexity.
 *
 */
public class DiffK {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(3);arr.add(5);
        System.out.println(findPossibleDifference(arr, 4));
    }

    public static int findPossibleDifferenceNew(List<Integer> num, int k){
        int i = 0, j = 1;
        while (j < num.size() && i < num.size()){
            int diff = num.get(j) - num.get(i);

            if (diff == k && i != j){
                return 1;
            }
            else if (diff > k){
                ++i;
            }
            else {
                ++j;
            }
        }
        return 0;
    }



    public static int findPossibleDifference(List<Integer> num, int k){
        int i = 0, j = 1;
        boolean right = true;

        while (i < j) {
            if (num.get(j) - num.get(i) == k)
                return 1;
            else {
                if (right){
                    j = binarySearchGreater(num, i, num.size() - 1, k - num.get(j));
                    right = false;
                }
                else {
                    i = binarySearchLesser(num, i, j, k - num.get(j));
                    right = true;
                }
            }
        }
        return 0;
    }

    public static int binarySearchGreater(List<Integer> num, int start, int end, int toSearch){
        int i = start, j = end;
        while (i <= j){
            int mid = i + ((j - i)/ 2);
            if (toSearch < num.get(mid)){
                j = mid;
                continue;
            }
            else if (toSearch > num.get(mid + 1)){
                i = mid;
                continue;
            }
            else if (num.get(mid) == toSearch){
                return mid;
            }
            else
                return mid+1;

        }
        return i;
    }

    public static int binarySearchLesser(List<Integer> num, int start, int end, int toSearch){
        int i = start, j = end;
        while (i <= j){
            int mid = i + ((j - i)/ 2);
            if (toSearch < num.get(mid)){
                j = mid;
                continue;
            }
            else if (toSearch > num.get(mid + 1)){
                i = mid;
                continue;
            }
            else if (num.get(mid + 1) == toSearch){
                return mid + 1;
            }
            else
                return mid;

        }
        return i;
    }



}
