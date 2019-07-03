package TwoPointers;

import java.util.List;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 *
 * Calculate the minimum absolute difference between the maximum and
 * minimum number from the triplet a, b, c such that a, b, c
 * belongs arrays A, B, C respectively.
 *
 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
 *
 * Example :
 *
 * Input:
 *
 * A : [ 1, 4, 5, 8, 10 ]
 * B : [ 6, 9, 15 ]
 * C : [ 2, 3, 6, 6 ]
 *
 * Output:
 *
 * 1
 * Explanation: We get the minimum difference for a=5, b=6,
 * c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 *
 */
public class MinimizeTheAbsoluteDifference {

    public int getMinimumAbsoluteDiff(List<Integer> a, List<Integer> b, List<Integer> c){
        int i = 0, j = 0, k = 0;
        int l = a.size(), m = b.size(), n = c.size();
        int minDifference = Integer.MAX_VALUE;

        int min, max;

        while ((i < l) && (j < m) && (k < n)){
            min = Math.min(a.get(i), Math.min(b.get(j), c.get(k)));
            max = Math.max(a.get(i), Math.max(b.get(j), c.get(k)));
            if (Math.abs(max - min) < minDifference){
                minDifference = Math.abs(max - min);
                if (minDifference == 0) break;
            }

            if (a.get(i) == min) ++i;
            else if (b.get(j) == min) ++j;
            else ++k;

        }
        return minDifference;
    }





}
