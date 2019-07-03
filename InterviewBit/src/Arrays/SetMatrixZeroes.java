package Arrays;

import java.util.ArrayList;

/**
 * Given an m x n matrix of 0s and 1s, if an element is 0,
 * set its entire row and column to 0.
 *
 * Do it in place.
 *
 * Example
 *--------------------------------------------------------
 * Given array A as
 *
 * 1 0 1
 * 1 1 1
 * 1 1 1
 * On returning, the array A should be :
 *
 * 0 0 0
 * 1 0 1
 * 1 0 1
 *
 * Note that this will be evaluated on the extra memory used.
 * Try to minimize the space and time complexity.
 *
 */
public class SetMatrixZeroes {

    public void setZeroes(ArrayList<ArrayList<Integer>> mat) {

        int n = mat.size();
        int m = mat.get(0).size();

        boolean firstRow = false, firstCol = false;

        for (int i = 0; i < m; ++i)
            if (mat.get(0).get(i) == 0){
                firstRow = true;
                break;
            }


        for (int i = 0; i < n; ++i)
            if (mat.get(i).get(0) == 0){
                firstCol = true;
                break;
            }



        for (int i = 0; i < n; ++i){
            for (int j = 0; j < m; ++j){
                if (mat.get(i).get(j) == 0){
                    mat.get(i).set(0, 0);
                    mat.get(0).set(j, 0);
                }
            }
        }

        for (int i = 1; i < n; ++i){
            for (int j = 1; j < m; ++j){
                if (mat.get(i).get(0) == 0 || mat.get(0).get(j) == 0){
                    mat.get(i).set(j, 0);
                }
            }
        }

        if (firstRow){
            for (int i = 0; i < m; ++i)
                mat.get(0).set(i, 0);
        }

        if (firstCol){
            for (int i = 0; i < n; ++i)
                mat.get(i).set(0, 0);
        }
        return;
    }



}
