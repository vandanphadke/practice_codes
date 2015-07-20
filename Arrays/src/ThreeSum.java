import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q: Given an array S of n integers, are there elements a, b, c in S 
 * such that a + b + c = 0? Find all unique triplets in the array which 
 * gives the sum of zero.
 * @author Vandan Phadke
 *
 */
public class ThreeSum {
	public static void main(String[] args) {
		int[] arr = new int[]{-1,0,1,2,-1,-4};
		System.out.println(threeSum(arr));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        int index = 0;
        while (index < nums.length - 2 && nums[index] <= 0) {
            if (result.size() != 0 && index > 0 && nums[index] == nums[index - 1]) {
                index ++;
                continue;
            }
            int front = index + 1;
            int tail = nums.length - 1;
            while (front < tail) {
                if (nums[front] + nums[tail] == nums[index] * (-1)) {
                    if (!(result.size() != 0 && 
                          result.get(result.size() - 1).get(0) == nums[index] && 
                          result.get(result.size() - 1).get(1) == nums[front] && 
                          result.get(result.size() - 1).get(2) == nums[tail])) {

                        List<Integer> item = new ArrayList<Integer>();
                        item.add(nums[index]);
                        item.add(nums[front]);
                        item.add(nums[tail]);
                        result.add(item);
                    } 
                    front ++;
                    tail --;
                } else if (nums[front] + nums[tail] < nums[index] * (-1)) {
                    front ++;
                } else {
                    tail --;
                }
            }
            index ++;
        }
        return result;
    }
}
