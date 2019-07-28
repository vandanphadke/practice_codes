package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * You are given with an array of 1s and 0s. And you are given with an integer M,
 * which signifies number of flips allowed. Find the position of zeros which when
 * flipped will produce maximum continuous series of 1s.
 *
 * For this problem, return the indices of maximum continuous series of 1s in order.
 *
 * Example:
 *
 * Input :
 * Array = {1 1 0 1 1 0 0 1 1 1 }
 * M = 1
 *
 * Output :
 * [0, 1, 2, 3, 4]
 *
 * If there are multiple possible solutions, return the sequence which has the
 * minimum start index.
 *
 */
public class MaxContinuousSeries1s {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(0);arr.add(0);arr.add(1);arr.add(1);
        arr.add(0);arr.add(1);arr.add(0);arr.add(1);arr.add(1);
        System.out.println(getMaxIndices(arr, 2));
    }

    public static ArrayList<Integer> getMaxIndices(List<Integer> arr, int m){
        int windowLeft = 0, windowRight = 0;
        int bestWindowLeft = 0, bestWindowRight = 0, bestWindowLength = Integer.MIN_VALUE;
        int currentZeroCount = 0;

        while (windowRight < arr.size()){
            if (currentZeroCount <= m)
            {
                if (arr.get(windowRight) == 0)
                    currentZeroCount++;
                ++windowRight;
            }

            if (currentZeroCount > m)
            {
                if (arr.get(windowLeft) == 0)
                    --currentZeroCount;
                windowLeft++;
            }

            if ((windowRight - windowLeft > bestWindowLength) && (currentZeroCount<=m))
            {
                bestWindowLength = windowRight - windowLeft;
                bestWindowLeft = windowLeft;
                bestWindowRight = windowRight;
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = bestWindowLeft; i < bestWindowRight; ++i){
            results.add(i);
        }
        return results;
    }

}
