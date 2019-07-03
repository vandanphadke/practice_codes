package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find longest Arithmetic Progression in an integer array and return its length.
 * More formally, find longest sequence of indeces,
 * 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that
 * sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression.
 * Arithmetic Progression is a sequence in which all the differences
 * between consecutive pairs are the same, i.e sequence B[0], B[1], B[2], …, B[m - 1]
 * of length m is an Arithmetic Progression if and only
 * if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2].
 *
 * Examples
 * 1) 1, 2, 3(All differences are equal to 1)
 * 2) 7, 7, 7(All differences are equal to 0)
 * 3) 8, 5, 2(Yes, difference can be negative too)
 *
 * Samples
 * 1) Input: 3, 6, 9, 12
 * Output: 4
 *
 * 2) Input: 9, 4, 7, 2, 10
 * Output: 3(If we choose elements in positions 1, 2 and 4(0-indexed))
 *
 */
public class LongestArithmeticProgression {

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(3);a.add(6);a.add(9);a.add(12);
        System.out.println(getLongestLength1(a));

        ArrayList<Integer> b = new ArrayList<>();
        b.add(9);b.add(4);b.add(7);b.add(2);b.add(10);
        System.out.println(getLongestLength1(b));

        ArrayList<Integer> c = new ArrayList<>();
        c.add(8);c.add(5);c.add(2);
        System.out.println(getLongestLength1(c));


    }



    public static int getLongestLength1(ArrayList<Integer> arr){
        //Collections.sort(arr);
        int n = arr.size();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i)
            dp[i][n-1] = 2;


        for (int j = n - 2; j >= 1; --j){

            int i = j - 1;
            int k = j + 1;

            while (i >= 0 && k <= n - 1){

                int diff1 = (arr.get(j) - arr.get(i));
                int diff2 = (arr.get(k) - arr.get(j));

                if (diff1 == diff2){
                    dp[i][j] = 1 + dp[j][k];
                    ++k;
                    --i;
                }
                else if (diff1 < diff2){
                    ++k;
                }
                else {
                    dp[i][j] = 2;
                    --i;
                }
            }


            while (i >= 0){
                dp[i][j] = 2;
                --i;
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i){
            for (int j = 0; j < n; ++j){
                if (dp[i][j] > maxLen)
                    maxLen = dp[i][j];
            }
        }

        return maxLen;
    }

}
