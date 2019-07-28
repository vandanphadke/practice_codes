package stacks;

import java.util.*;

/**
 * A long array A[] is given to you. There is a sliding window of size
 * w which is moving from the very left of the array to the very right. You can only see the w numbers in the window.
 * Each time the sliding window moves rightwards by one position. You have to find the
 * maximum for each window. The following example will give you more clarity.
 *
 * Example :
 *
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 *
 * Window position	Max
 *
 * [1 3 -1] -3 5 3 6 7	3
 * 1 [3 -1 -3] 5 3 6 7	3
 * 1 3 [-1 -3 5] 3 6 7	5
 * 1 3 -1 [-3 5 3] 6 7	5
 * 1 3 -1 -3 [5 3 6] 7	6
 * 1 3 -1 -3 5 [3 6 7]	7
 * Input: A long array A[], and a window width w
 * Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
 * Requirement: Find a good optimal way to get B[i]
 */
public class SlidingWindowMaximum {

    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(12, 1, 78, 90, 57, 89, 56);
        System.out.println(getSlidingWindowMax(arr, 3));
    }

    public static ArrayList<Integer> getSlidingWindowMax(List<Integer> arr, int k){
        if (k >= arr.size()){
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.size(); ++i){
                if (arr.get(i) < max) max = arr.get(i);
            }

            ArrayList<Integer> res = new ArrayList<>();
            res.add(max);
            return res;
        }

        ArrayList<Integer> results = new ArrayList<>();
        Deque<Integer> integerDeque = new LinkedList<>();
        int i = 0;
        for (; i < k; ++i){
            while (!integerDeque.isEmpty() && arr.get(i) >= arr.get(integerDeque.peekLast())){
                integerDeque.removeLast();
            }
            integerDeque.addLast(i);
        }

        for (; i < arr.size(); ++i){
            results.add(arr.get(integerDeque.peekFirst()));

            while (!integerDeque.isEmpty() && integerDeque.peekFirst() <= i - k){
                integerDeque.removeFirst();
            }

            while (!integerDeque.isEmpty() && arr.get(i) >= arr.get(integerDeque.peekLast())){
                integerDeque.removeLast();
            }

            integerDeque.addLast(i);
        }
        results.add(arr.get(integerDeque.peekFirst()));
        return results;
    }

}
