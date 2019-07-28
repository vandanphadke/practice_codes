package TwoPointers;

import java.util.List;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent
 * the color red, white, and blue respectively.
 *
 * Note: Using library sort function is not allowed.
 *
 * Example :
 *
 * Input : [0 1 2 0 1 2]
 * Modify array so that it becomes : [0 0 1 1 2 2]
 */
public class CountingColors {

    public void sortColors(List<Integer> colors){
        int[] counts = new int[3];
        for(int color : colors){
            ++counts[color];
        }

        int j = 0;
        for(int i = 0; i < colors.size(); ++i){
            if(counts[j] == 0){
                ++j;
            }
            colors.set(i, j);
            --counts[j];
        }
    }

}
