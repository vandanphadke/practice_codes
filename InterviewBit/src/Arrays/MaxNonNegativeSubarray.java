package Arrays;

import java.util.ArrayList;

/**
 *
 * Q: Find out the maximum sub-array of non negative numbers from an array.
 * The sub-array should be continuous. That is, a sub-array created by
 * choosing the second and fourth element and skipping the
 * third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the
 * elements in the sub-array.
 * Sub-array A is greater than sub-array B if sum(A) > sum(B).
 *
 * Example:
 *
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 *
 */
public class MaxNonNegativeSubarray {

    public static ArrayList<Integer> maxPosSubarray(int[] A){
        int i = 0, j = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxi = Integer.MIN_VALUE, maxj = Integer.MIN_VALUE;
        while (i< A.length && j < A.length){
            i = j;

            while (A[i] < 0){
                ++i;
            }

            j = i;
            int sum = 0;
            while (j < A.length && A[j] >= 0){
                sum += A[j];
                ++j;
            }
            if (sum > maxSum){
                maxSum = sum;
                maxi = i;
                maxj = j-1;
            }
            else if(sum == maxSum && ((j-1) - i > (maxj - maxi))){
                maxi = i;
                maxj = j-1;
            }
        }
        System.out.println("I is " + maxi + " and J is " + maxj + " sum is " + maxSum);

        return null;
    }

    public static void main(String[] args){
        maxPosSubarray(new int[]{1, 2, 5, -7, 2, 3});
    }
}
