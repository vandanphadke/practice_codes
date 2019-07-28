package BinarySearch;

import java.util.Arrays;
import java.util.List;

/**
 * There are two sorted arrays A and B of size m and n respectively.
 *
 * Find the median of the two sorted arrays ( The median of the array
 * formed by merging both the arrays ).
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Sample Input
 *
 * A : [1 4 5]
 * B : [2 3]
 *
 * Sample Output
 *
 * 3
 */
public class MedianOfArray {

    public static void main(String[] args){
        List<Integer> arr1 = Arrays.asList(1, 4, 5, 7);
        List<Integer> arr2 = Arrays.asList(2, 3, 6);
        System.out.println(getTwoArraysMedian(arr1, arr2));
    }

    public static double getTwoArraysMedian(List<Integer> arr1, List<Integer> arr2){
        int m = arr1.size(), n = arr2.size();
        if (m > n) return getTwoArraysMedian(arr2, arr1);
        int low = 0, high = m, partitionX = 0, partitionY = 0;
        while (low <= high){
            partitionX = (low + high) / 2;
            partitionY = ((m + n + 1) / 2) - partitionX;
            int maxX = partitionX == 0 ? Integer.MIN_VALUE : arr1.get(partitionX - 1);
            int maxY = partitionY == 0 ? Integer.MIN_VALUE : arr2.get(partitionY - 1);
            int minX = partitionX == m ? Integer.MAX_VALUE : arr1.get(partitionX);
            int minY = partitionY == n ? Integer.MAX_VALUE : arr2.get(partitionY);
            if (maxX <= minY && maxY <= minX){
                if ((m + n) % 2 == 0){
                    return ((double)Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                }
                else {
                    return Math.max(maxX, maxY);
                }
            }
            else if (maxX > minY){
                high = partitionX - 1;
            }
            else {
                low = partitionX + 1;
            }
        }

        return 0;
    }
}
