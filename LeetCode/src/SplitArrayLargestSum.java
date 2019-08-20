import java.util.Arrays;

/**
 * Given an array which consists of non-negative integers and an integer m, you can split
 * the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest
 * sum among these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {

    public int splitArrayDp(int[] nums, int m) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[][] dp = new int[n][m+1];
        for (int i = 0; i < n; ++i)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        int sum = 0;
        for (int i = 0; i < n; ++i){
            sum += nums[i];
            dp[i][1] = sum;
        }

        for (int j = 2; j <= m; ++j){
            for (int i = 0; i < n; ++i){
                for (int k = 0; k < i; ++k){
                    dp[i][j] = Math.min(dp[i][j],
                                        Math.max(dp[i][1] - dp[k][1],
                                                 dp[k][j-1]));
                }
            }
        }
        return dp[n-1][m];
    }

    public int splitArrayBS(int[] nums, int m) {
        int lo = getMin(nums);
        int hi = getSum(nums);
        while (lo < hi) {
            int minLvl = (lo + hi + 1) >>> 1;
            if (split(nums, minLvl) < m) {
                hi = minLvl - 1;
            } else {
                lo = minLvl;
            }
        }
        return lo;
    }

    private int split(int[] chocolate, int minSweetness) {
        int peopleCount = 0;
        int sweetness = 0;
        for (int val : chocolate) {
            sweetness += val;
            if (sweetness >= minSweetness) {
                peopleCount++;
                sweetness = 0;
            }
        }
        return peopleCount;
    }

    private int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int val : arr) {
            min = Math.min(min, val);
        }
        return min;
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        return sum;
    }
}
