package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given two arrays A & B of size N each.
 * Find the maximum n elements from the sum combinations (Ai + Bj)
 * formed from elements in array A and B.
 *
 * For example if A = [1,2], B = [3,4], then possible pair sums can be
 * 1+3 = 4 , 1+4=5 , 2+3=5 , 2+4=6
 * and maximum 2 elements are 6, 5
 *
 * Example:
 *
 * N = 4
 * a[]={1,4,2,3}
 * b[]={2,5,1,6}
 *
 * Maximum 4 elements of combinations sum are
 * 10   (4+6),
 * 9    (3+6),
 * 9    (4+5),
 * 8    (2+6)
 */
public class NMaxPairCombinations {


    public static void main(String[] args){
        List<Integer> a = new ArrayList<>();
        a.add(1);a.add(4);a.add(2);a.add(3);

        List<Integer> b = new ArrayList<>();
        b.add(2);b.add(5);b.add(1);b.add(6);

        System.out.println(getMaxSumElements(a, b, 4));
    }


    public static List<Integer> getMaxSumElements(List<Integer> A, List<Integer> B, int n){
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int a: A) p.add(a);
        for (int b: B) q.add(b);

        List<Integer> results = new ArrayList<>();
        int i = 0;
        while (i < n){
            if (p.peek() > q.peek()){
                int max1 = p.poll();
                int max2 = q.peek();

                List<Integer> temp = new ArrayList<>();
                while (i < n && !q.isEmpty() && max1 + q.peek() >= max2 + p.peek()){
                    results.add(max1 + q.peek());
                    temp.add(q.poll());
                    ++i;
                }
                for (int t: temp) q.add(t);
            }
            else{
                int max1 = q.poll();
                int max2 = p.peek();

                List<Integer> temp = new ArrayList<>();
                while (i < n && !p.isEmpty() && max1 + p.peek() >= max2 + q.peek()){
                    results.add(max1 + p.peek());
                    temp.add(p.poll());
                    ++i;
                }
                for (int t: temp) p.add(t);
            }
        }
        return results;

    }

}
