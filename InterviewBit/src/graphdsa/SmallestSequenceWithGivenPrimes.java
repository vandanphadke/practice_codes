package graphdsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * Given three prime number(p1, p2, p3) and an integer k. Find the
 * first(smallest) k integers which have only p1, p2, p3 or a
 * combination of them as their prime factors.
 *
 * Example:
 *
 * Input :
 * Prime numbers : [2,3,5]
 * k : 5
 *
 * If primes are given as p1=2, p2=3 and p3=5 and k is given as 5,
 * then the sequence of first 5 integers will be:
 *
 * Output:
 * {2,3,4,5,6}
 *
 * Explanation :
 * 4 = p1 * p1 ( 2 * 2 )
 * 6 = p1 * p2 ( 2 * 3 )
 *
 * Note: The sequence should be sorted in ascending order
 *
 */
public class SmallestSequenceWithGivenPrimes {

    public static void main(String[] args){
        System.out.println(getListPrimes(2, 3, 5, 5));
    }

    public static ArrayList<Integer> getListPrimes(int p1, int p2, int p3, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> added = new HashSet<>();
        ArrayList<Integer> results = new ArrayList<>();
        pq.add(p1);
        added.add(p1);
        if (!added.contains(p2)){
            pq.add(p2);
            added.add(p2);
        }
        if (!added.contains(p3)){
            pq.add(p3);
            added.add(p3);
        }

        for (int i = 0; i < k; ++i){
            int smallest = pq.poll();
            results.add(smallest);
            if (!added.contains(smallest * p1)){
                pq.add(smallest * p1);
                added.add(smallest * p1);
            }
            if (!added.contains(smallest * p2)){
                pq.add(smallest * p2);
                added.add(smallest * p2);
            }
            if (!added.contains(smallest * p3)){
                pq.add(smallest * p3);
                added.add(smallest * p3);
            }
        }
        return results;
    }


}
