/**
 * Given an integer array nums, find the sum of the elements between indices
 * i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {

    int[] cumulative;
    public RangeSumQueryImmutable(int[] nums) {
        cumulative = new int[nums.length + 1];
        cumulative[0] = 0;
        for(int i = 1; i <= nums.length; ++i){
            cumulative[i] = cumulative[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return cumulative[j+1] - cumulative[i];
    }
}
