package GeeksForGeeks;

import java.util.Arrays;

/**
 * Q: Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even.
 *    We play a game against an opponent by alternating turns. In each turn,
 *    a player selects either the first or last coin from the row,
 *    removes it from the row permanently, and receives the value of the coin.
 *    Determine the maximum possible amount of money we can definitely win if we move first.
 *
 *    Note: The opponent is as clever as the user.
 * @author vandan
 *
 */
public class GameOptimalStrategy {

    public static void main(String[] args){
        int[] val = {20, 30, 2, 2, 2, 10};
        System.out.println(getOptimalValue(val));
    }

    public static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
        System.out.println();
    }

    public static int getOptimalValue(int[] value){
        int n = value.length;
        int[][] opt = new int[n][n];

        for (int i = 0; i < opt.length; ++i)
            opt[i][i] = value[i];

        for (int k = 1; k < n; ++k){
            for (int i = 0, j = k; i < n - k; ++i, ++j){
                int left = (i + 2 <= j) ? opt[i+2][j] : 0;
                int right = (j - 2 >= i) ? opt[i][j- 2] : 0;
                opt[i][j] = Math.max(
                            Math.min(left, opt[i + 1][j - 1]) + value[i],
                            Math.min(right, opt[i+1][j-1]) + value[j]
                );
            }
        }

        return opt[0][n-1];
    }


}
