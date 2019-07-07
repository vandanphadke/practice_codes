package graphdsa;

import java.util.PriorityQueue;

/**
 * You are given an integer N. You have to find smallest multiple of
 * N which consists of digits 0 and 1 only. Since this multiple could
 * be large, return it in form of a string.
 *
 * Note:
 *
 * Returned string should not contain leading zeroes.
 * For example,
 *
 * For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
 * For N = 2, 10 is the answer.
 */
public class SmallestMultipleWith01 {

   public static int getSmallestMultiple(int N){
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       pq.add(1);
       while (!pq.isEmpty()){
           int current = pq.poll();
           if (current % N == 0)
               return current;
           pq.add(current * 10);
           pq.add((current * 10) + 1);
       }
       return 0;
   }


}
