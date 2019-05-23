package Arrays;

import java.util.Arrays;

/**
 *
 *
 */
public class SpiralOrderII {

    public static void main(String[] args){
        int[][] mat = generateSpiralOrder(80);
        for (int i = 0; i < mat.length; ++i){
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    public static int[][] generateSpiralOrder(int n){
        int[][] result = new int[n][n];
        int number = 1;
        for (int k = 0; k < n/2; ++k){
            int i = k;
            int j = k;
            while (j < n - k){
                result[i][j] = number;
                ++number;
                ++j;
            }
            ++i;
            --j;
            while (i < n - k){
                result[i][j] = number;
                ++number;
                ++i;
            }
            --i;
            --j;
            while (j >= k){
                result[i][j] = number;
                ++number;
                --j;
            }
            ++j;
            --i;
            while (i > k) {
                result[i][j] = number;
                ++number;
                --i;
            }
        }
        return result;
    }


}
