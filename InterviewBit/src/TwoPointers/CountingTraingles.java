package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * You are given an array of N non-negative integers, A0, A1 ,…, AN-1.
 * Considering each array element Ai as the edge length of some line
 * segment, count the number of triangles which you can form using these array values.
 *
 * Notes:
 *
 * You can use any value only once while forming each triangle. Order of choosing
 * the edge lengths doesn’t matter. Any triangle formed should have a positive area.
 *
 * Return answer modulo 109 + 7.
 *
 * For example,
 *
 * A = [1, 1, 1, 2, 2]
 *
 * Return: 4
 *
 */
public class CountingTraingles {

    public static int countNumberTriangles(ArrayList<Integer> arr){
        if (arr.size() < 3) return 0;

        Collections.sort(arr);
        long total = 0;
        final int MOD = 1000000007;

        for (int sumI = arr.size() - 1; sumI >= 0; --sumI){
            int current = arr.get(sumI);
            int i = 0;
            int j = sumI - 1;
            while (i < j){
                long sum = arr.get(i) + arr.get(j);
                if (sum > current){
                    total = total + (((j - i) % MOD) % MOD);
                    --j;
                }
                else {
                    ++i;
                }
            }

        }

        return (int)(total % MOD);
    }


}
