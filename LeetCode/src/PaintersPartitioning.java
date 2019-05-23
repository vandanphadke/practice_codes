import java.util.Arrays;

/**
 * Q: You have to paint N boards of length {A0, A1, A2 … AN-1}.
 * There are K painters available and you are also given how much time a painter takes to paint 1 unit of board.
 * You have to get this job done as soon as possible under the constraints that any painter will only paint continuous
 * sections of board, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 *
 *
 *
 *
 */
public class PaintersPartitioning {

    public static void main(String[] args){
        int[] A = {100, 200, 300, 400, 500, 600, 700, 800, 900};
        int k = 3;
        System.out.println(getPartitions(A, k));
    }

    private static int getPartitions(int[] a, int k) {
        int highestCost = getArraySum(a);
        int lowestCost = getMaxArray(a);

        while (highestCost <= lowestCost){
            int midCost = lowestCost + (highestCost - lowestCost)/2;
            int n = getNumberPainters(a, midCost);
            if (n <= k){
                highestCost = midCost;
            }
            else
                lowestCost = midCost + 1;


        }

        return lowestCost;
    }

    private static int getNumberPainters(int[] arr, int cost){
        int numPainters = 1;
        int currentCost = 0;
        for (int i = 0 ; i < arr.length; ++i){
            currentCost += arr[i];
            if (currentCost > cost){
                currentCost = arr[i];
                ++numPainters;
            }
        }
        return numPainters;
    }

    private static int getArraySum(int[] arr){
        return Arrays.stream(arr).sum();
    }

    private static int getMaxArray(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

}
