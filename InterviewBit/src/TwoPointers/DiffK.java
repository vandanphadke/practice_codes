package TwoPointers;

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

    public static int findPossibleDifference(List<Integer> num, int k){

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
