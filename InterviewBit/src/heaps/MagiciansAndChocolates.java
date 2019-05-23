package heaps;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 Given N bags, each bag contains Ai chocolates.
 There is a kid and a magician. In one unit of time,
 kid chooses a random bag i, eats Ai chocolates,
 then the magician fills the ith bag with floor(Ai/2) chocolates.

 Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

 For example,

 K = 3
 N = 2
 A = 6 5

 Return: 14
 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
 so, total number of chocolates eaten: 6 + 5 + 3 = 14

 Note: Return your answer modulo 10^9+7

 */

public class MagiciansAndChocolates {

    public static int getMaxChocolates(List<Integer> chocolates, int k){
        int total = 0;
        int max = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int c: chocolates) priorityQueue.add(c);

        for (int i = 0; i < k; ++i){
            max = priorityQueue.poll();
            total = (total + max) % 1000000007;
            priorityQueue.add(Math.floorDiv(max, 2));
        }

        return total % 1000000007;
    }

}
