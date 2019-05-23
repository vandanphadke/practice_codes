/**
 * Q: https://www.interviewbit.com/problems/maximum-absolute-difference/
 *
 * Given an unsorted array A of N integers,
 * A_{1}, A_{2}, ...., A_{N}.
 * Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 * f(i, j) or absolute difference of two elements of an array A is defined as
 *    |A[i] – A[j]| + |i – j|, where |A| denotes
 *
 * the absolute value of A.
 */
public class MaxAbsDiffValuesAndIndex {

    public static void main(String[] args){

    }

    private static int maxDistance(int[] array)
    {

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++)
        {

            max1 = Math.max(max1, array[i] + i);
            min1 = Math.min(min1, array[i] + i);
            max2 = Math.max(max2, array[i] - i);
            min2 = Math.min(min2, array[i] - i);
        }

        // Calculating maximum absolute difference.
        return Math.max(max1 - min1, max2 - min2);
    }


}
