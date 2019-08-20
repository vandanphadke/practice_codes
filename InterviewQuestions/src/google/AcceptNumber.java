package google;

import java.util.PriorityQueue;

/**
 * Part A: Given a 1-D array and a black-box function-accept which takes as an input an integer and
 * returns a boolean. Find the maxinum number in the array which passes the acceptance test.
 *
 * Part B: Given a 2D array consisting of a finite number of columns but infinite rows.
 * The first row is sorted in increasing order. The second row contains the numbers in
 * the first row / 2, the third row / 3 and so on... find the largest accepted number.
 */
public class AcceptNumber {
    public static boolean accept(double num){
        double rand = (Math.random() * ((100 - 0) + 1));
        if (rand < 50) return false;
        return true;
    }

    public static int getmaxAcceptingI(int[] nums){
        int maxNum = Integer.MIN_VALUE;
        for (int number : nums){
            if (number > maxNum && accept(number)){
                maxNum = number;
            }
        }
        return maxNum;
    }

    static class NumFactor {
        int num;
        int factor;

        public NumFactor(int num, int factor) {
            this.num = num;
            this.factor = factor;
        }
    }

    public static double getmaxAcceptingII(int[][] nums){
        int n = nums[0].length;
        PriorityQueue<NumFactor> heap = new PriorityQueue<>(
                (o1, o2) -> (o2.num/o2.factor) - (o1.num/o1.factor));

        for (int i = 0; i < n; ++i){
            heap.add(new NumFactor(nums[0][i], 1));
        }
        // Heap will never be empty.
        while (!heap.isEmpty()){
            NumFactor current = heap.poll();
            if (accept(current.num / current.factor)){
                return ((double) current.num / current.factor);
            }
            heap.add(new NumFactor(current.num, current.factor + 1));
        }
        return 0;
    }
}
