package hashing;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K.
 * Return the of count of distinct numbers in all windows of size K.
 *
 * Formally, return an array of size N-K+1 where i’th element in this
 * array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.
 *
 * Note:
 *
 * If K > N, return empty array.
 * For example,
 *
 * A=[1, 2, 1, 3, 4, 3] and K = 3
 *
 * All windows of size K are
 *
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 *
 * So, we return an array [2, 3, 3, 2].
 */
public class DistinctNumbersWindow {

    public static void main(String[] args){
        ArrayList<Integer> num = new ArrayList<>();
        num.add(1);num.add(2);num.add(1);num.add(3);num.add(4);num.add(3);
        System.out.println(getDistinctElements(num, 3));
    }

    public static ArrayList<Integer> getDistinctElements(ArrayList<Integer> num, int k){
        if (num.size() < k) return new ArrayList<>();

        HashMap<Integer, Integer> distMap = new HashMap<>();
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < k; ++i)
            distMap.put(num.get(i), distMap.getOrDefault(num.get(i), 0) + 1);

        int distinct = distMap.size();
        results.add(distinct);

        for (int i = k; i < num.size(); ++i){
            int element = num.get(i - k);

            // Remove out-of-window element
            if (distMap.get(element) == 1){
                distMap.remove(element);
                --distinct;
            }
            else {
                distMap.put(element, distMap.get(element) - 1);
            }

            // Add in window element
            element = num.get(i);

            if (distMap.containsKey(element)){
                distMap.put(element, distMap.get(element) + 1);
            }
            else {
                distMap.put(element, 1);
                ++distinct;
            }
            results.add(distinct);
        }

        return results;
    }

}
