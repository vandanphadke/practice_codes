package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 < index2. Please note that your returned answers (both index1 and index2 )
 * are not zero-based.
 *
 * Put both these numbers in order in an array and return the array from your function ( Looking at the function signature will make things clearer ). Note that, if no pair exists, return empty list.
 *
 * If multiple solutions exist, output the one where index2 is minimum.
 * If there are multiple solutions with the minimum index2,
 * choose the one with minimum index1 out of them.
 *
 * Input: [2, 7, 11, 15], target=9
 * Output: index1 = 1, index2 = 2
 */
public class TwoSum {

    public static void main(String[] args){
        List<Integer> q = new ArrayList<>();
        q.add(2);q.add(7);q.add(11);q.add(15);
        System.out.println(get2Sum(q, 9));
    }

    public static List<Integer> get2Sum(List<Integer> arr, int target){
        HashMap<Integer, Integer> store = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < arr.size(); ++i){
            int current = arr.get(i);
            if (store.containsKey(target - current)){
                results.add(store.get(target - current) + 1);
                results.add(i + 1);
                return results;
            }
            if (!store.containsKey(current))
                store.put(arr.get(i), i);
        }

        return new ArrayList<>();
    }


}
