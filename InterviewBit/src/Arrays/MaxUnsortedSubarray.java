package Arrays;


import java.util.ArrayList;
import java.util.List;

/**
 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
 * Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order)
 * that sub array, then the whole array should get sorted.
 *
 * If A is already sorted, output -1.
 *
 * Example :
 *
 * Input 1:
 *
 * A = [1, 3, 2, 4, 5]
 *
 * Return: [1, 2]
 *
 * Input 2:
 *
 * A = [1, 2, 3, 4, 5]
 *
 * Return: [-1]
 *
 * In the above example(Input 1), if we sort the subarray A1, A2,
 * then whole array A should get sorted.
 *
 */
public class MaxUnsortedSubarray {

    public ArrayList<Integer> getMinSubarray(List<Integer> arr){
        int n = arr.size();
        ArrayList<Integer> results = new ArrayList<>();

        int i = 0;
        while (i < n - 1 && arr.get(i+1) > arr.get(i))
            ++i;

        // Array is already sorted
        if (i == n-1){
            results.add(-1);
            return results;
        }

        int min = Integer.MAX_VALUE;
        while(i < n){
            min = Math.min(min, arr.get(i));
            ++i;
        }


        int j = n-1;
        while (arr.get(j-1) < arr.get(j))
            --j;

        int max = Integer.MIN_VALUE;
        while(j >= 0){
            max = Math.max(max, arr.get(j));
            --j;
        }

        i = 0;
        while (i < n){
            if (min < arr.get(i))
                break;
            ++i;
        }

        j = n-1;
        while (j >= 0){
            if (max > arr.get(j))
                break;
            --j;
        }

        if (j - i < 0){
            results.add(-1);
        }
        else {
            results.add(i);
            results.add(j);
        }
        return results;
    }

}
