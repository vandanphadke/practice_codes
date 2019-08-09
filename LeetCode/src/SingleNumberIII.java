/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the
 * other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only
 * constant space complexity?
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xorVal = 0;
        for(int num : nums)
            xorVal = xorVal ^ num;


        int num1 = 0, num2 = 0;
        int bit = xorVal & ~(xorVal-1);
        int[] result = new int[2];
        for (int num : nums){
            if ((num & bit) > 0){
                num1 ^= num;
            }
            else{
                num2 ^= num;
            }
        }

        result[0] = num1;
        result[1] = num2;
        return result;
    }
}
