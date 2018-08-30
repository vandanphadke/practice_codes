import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Q: https://leetcode.com/problems/longest-mountain-in-array/description/
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 *
 * 1) B.length >= 3
 * 2) There exists some 0 < i < B.length - 1
 *    such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 *    (Note that B could be any subarray of A, including the entire array A.)
 *
 * Given an array A of integers, return the length of the longest mountain.
 *
 * Return 0 if there is no mountain.
 * @author vandan
 */
public class LongestMountainArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] contents = br.readLine().split(" ");
        int[] arr = Arrays.stream(contents).mapToInt(Integer::parseInt).toArray();
        System.out.println(getLargestMountainSize(arr));
        System.out.println(getLargestMountainPointers(arr));
    }

    /**
     * The solution involves passing from start to end to get the upward slope of the mountain
     * and another pass going from end to start to get the downward slope of the mountain
     * There are many problems with similar solutions involving two passes of the array
     * one increasing and one decreasing
     * @param A
     * @return size of maximum length mountain
     */
    private static int getLargestMountainSize(int[] A) {
        int[] up = new int[A.length];
        int[] down = new int[A.length];

        for (int i = A.length - 2; i >= 0; --i){
            if (A[i] > A[i+1])
                down[i] = down[i + 1] + 1;
        }

        for (int i = 1; i < A.length; ++i){
            if (A[i] > A[i-1])
                up[i] = up[i-1] + 1;
        }

        int max = 0;

        for (int i = 0 ; i < A.length ; ++i){
            if (up[i] > 0 && down[i] > 0)
                max = Math.max(max, up[i] + down[i] + 1);
        }

        return max;
    }

    private static int getLargestMountainPointers(int[] A){
        int N = A.length;
        int ans = 0, base = 0;
        while (base < N) {
            int end = base;
            // if base is a left-boundary
            if (end + 1 < N && A[end] < A[end + 1]) {
                // set end to the peak of this potential mountain
                while (end + 1 < N && A[end] < A[end + 1]) end++;

                // if end is really a peak..
                if (end + 1 < N && A[end] > A[end + 1]) {
                    // set end to the right-boundary of mountain
                    while (end + 1 < N && A[end] > A[end + 1]) end++;
                    // record candidate answer
                    ans = Math.max(ans, end - base + 1);
                }
            }

            base = Math.max(end, base + 1);
        }

        return ans;
    }
}
