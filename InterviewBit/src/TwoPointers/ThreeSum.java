package TwoPointers;

import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S such that
 * the sum is closest to a given number, target.
 *
 * Return the sum of the three integers.
 *
 * Assume that there will only be one solution
 *
 * Example:
 * given array S = {-1 2 1 -4},
 * and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 *
 */
public class ThreeSum {

    public int getThreeSumElements(List<Integer> arr, int sum){
        Collections.sort(arr);
        int currentSum = 0, minDiff = Integer.MAX_VALUE, result = 0;

        for (int i = 0; i < arr.size(); ++i){
            int j = i + 1;
            int k = arr.size() - 1;


            while (j < k){

                currentSum = arr.get(i) + arr.get(j) + arr.get(k);

                if (minDiff > Math.abs(currentSum - sum)){
                    minDiff = Math.abs(currentSum - sum);
                    result = currentSum;
                    if (minDiff == 0) return sum;
                }

                if (currentSum < sum) ++j;
                else --k;
            }
        }
        return result;
    }


}
