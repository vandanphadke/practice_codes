package backtracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 *  Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order.
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The combinations themselves must be sorted in ascending order.
 * CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR …
 * (a1 = b1 AND a2 = b2 AND … ai = bi AND ai+1 > bi+1)
 * The solution set must not contain duplicate combinations.
 * Example,
 * Given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 *
 * [2, 2, 3]
 * [7]
 */
public class CombinationSum {
    public static void main(String[] args){
        System.out.println(getSumCombinations(Arrays.asList(2, 3, 6, 7), 7));
    }

    public static ArrayList<ArrayList<Integer>> getSumCombinations(List<Integer> nums, int reqSum){
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums.size() == 0) {
            return results;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        getCombinationRecurse(nums, reqSum, temp, 0, results);
        return results;
    }

    public static void getCombinationRecurse(List<Integer> nums, int reqSum,
                                      ArrayList<Integer> temp, int index,
                                      ArrayList<ArrayList<Integer>> result){
        if (reqSum < 0) return;
        if (reqSum == 0){
            if (!result.contains(temp)){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < nums.size(); ++i){
            temp.add(nums.get(i));
            getCombinationRecurse(nums, reqSum - nums.get(i), temp, i, result);
            temp.remove(temp.size() - 1);
        }
    }
}
