import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubarraySumK {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] contents = br.readLine().split(" ");
        int[] nums = new int[contents.length];
        for (int i = 0 ; i < contents.length; ++i)
            nums[i] = Integer.parseInt(contents[i]);
        int k = Integer.parseInt(br.readLine());
        System.out.println(subarraySum(nums, k));

    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start){
            int sum = 0;
            for (int end = start; end < nums.length; ++end){
                sum += nums[end];
                if (sum == k)
                    ++count;
            }
        }
        return count;
    }
}
