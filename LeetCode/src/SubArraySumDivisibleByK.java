import java.util.Arrays;

/**
 * Given an array A of integers,
 * return the number of (contiguous, non-empty) subarrays
 * that have a sum divisible by K.
 *
 * Example 1:
 *
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class SubArraySumDivisibleByK {
    public static int subarraysDivByK(int[] A, int K) {
        int cumulative = 0;
        int[] remainders = new int[K];
        Arrays.fill(remainders, 0);
        for (int i = 0; i < A.length; ++i){
            cumulative += A[i];

            if (cumulative >= 0){
                ++remainders[cumulative % K];
            }
            else {
                int val = ((cumulative % K) + K) % K;
                ++remainders[val];
            }

        }
        int result = 0;
        for (int remainder : remainders) {
            if (remainder > 0)
                result += (remainder * (remainder - 1)) / 2;
        }
        result += remainders[0];

        return result;
    }
}
