package hashing;

import java.util.HashSet;
import java.util.List;

/**
 *
 * Given an array A of integers and another non negative integer k,
 * find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 *
 * Example :
 *
 * Input :
 *
 * A : [1 5 3]
 * k : 2
 * Output :
 *
 * 1
 * as 3 - 1 = 2
 *
 * Return 0 / 1 for this problem.
 *
 */
public class DiffkII {
    public int checkDifference(List<Integer> arr, int k){
        HashSet<Integer> store = new HashSet<>();
        for (int i = 0; i < arr.size(); ++i){
            if (store.contains(arr.get(i) - k) || store.contains(k + arr.get(i))){
                return 1;
            }
            store.add(arr.get(i));
        }
        return 0;
    }
}
