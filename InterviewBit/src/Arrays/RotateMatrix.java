package Arrays;

import java.util.List;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * You need to do this in place.
 *
 * Note that if you end up using an additional array, you will only receive partial score.
 *
 * Example:
 *
 * If the array is
 *
 * [
 *     [1, 2],
 *     [3, 4]
 * ]
 * Then the rotated array becomes:
 *
 * [
 *     [3, 1],
 *     [4, 2]
 * ]
 */
public class RotateMatrix {

    public void getRotatedMatrix(List<List<Integer>> image){
        int n = image.size();

        // Transpose of a matrix
        for (int i = 0; i < n; ++i){
            for (int j = i; j < n; ++j){
                if (i != j){
                    int temp = image.get(i).get(j);
                    image.get(i).set(j, image.get(j).get(i));
                    image.get(j).set(i, temp);
                }
            }
        }

        // Reverse the elements of each row
        for (int i = 0; i < n; ++i){
            int j = 0, k = n-1;
            while (j < k){
                int temp = image.get(i).get(j);
                image.get(i).set(j, image.get(i).get(k));
                image.get(i).set(k, temp);
                ++j;
                --k;
            }
        }
    }



}
