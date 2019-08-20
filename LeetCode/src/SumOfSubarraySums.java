import java.util.Stack;

public class SumOfSubarraySums {

    public static void main(String[] args){
        int[] arr = {1,7,5,2,4,3,9};
        System.out.println(sumSubarrayMins(arr));
    }

    static class RepInteger {
        int val, count;
        RepInteger(int v, int c) {
            val = v;
            count = c;
        }

        @Override
        public String toString() {
            return val + "  " + count;
        }
    }

    public static int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;

        Stack<RepInteger> stack = new Stack();
        int ans = 0, dot = 0;
        for (int j = 0; j < A.length; ++j) {
            // Add all answers for subarrays [i, j], i <= j
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
                RepInteger node = stack.pop();
                count += node.count;
                dot -= node.val * node.count;
            }
            stack.push(new RepInteger(A[j], count));
            dot += A[j] * count;
            ans += dot;
            ans %= MOD;
        }

        return ans;
    }
}
