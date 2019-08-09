import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide
 * this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal
 * sums.
 *
 *
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class PartitionKEqualSumSubsets {
    public static void main(String[] args){
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(nums, 4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % k != 0) return false;
        int reqSum = totalSum / k;
        Arrays.sort(nums);
        if (nums[n-1] > reqSum) return false;
        int end = n-1;
        while (end >= 0 && nums[end] == reqSum){
            --end;
            --k;
        }
        int[] buckets = new int[k];
        return checkSumRecurse(nums, buckets, end, reqSum);
    }

    public static boolean checkSumRecurse(int[] nums, int[] buckets, int end, int reqSum){
        if (end < 0) return true;

        for (int i = 0; i < buckets.length; ++i){
            if (buckets[i] + nums[end] <= reqSum){
                buckets[i] += nums[end];
                if (checkSumRecurse(nums, buckets, end - 1, reqSum))
                    return true;
                buckets[i] -= nums[end];
            }
            if (buckets[i] == 0) break;
        }
        return false;
    }

}
