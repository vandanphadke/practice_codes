package hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array S of n integers, are there elements
 * a, b, c, and d in S such that a + b + c + d = target?
 *
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * Example :
 * Given array S = {1 0 -1 0 -2 2}, and target = 0
 * A solution set is:
 *
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *     (-1,  0, 0, 1)
 * Also make sure that the solution set is lexicographically sorted.
 * Solution[i] < Solution[j] iff Solution[i][0] < Solution[j][0] OR
 * (Solution[i][0] == Solution[j][0] AND ... Solution[i][k] < Solution[j][k])
 *
 */
public class FourSum {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(0);arr.add(-1);
        arr.add(2);arr.add(0);arr.add(-2);
        System.out.println(getfoursum(arr, 0));
    }


    public static ArrayList<ArrayList<Integer>> getfoursum(List<Integer> arr, int target){
        int n = arr.size();
        Collections.sort(arr);

        if (n < 4)
            return new ArrayList<>();

        int k = 0;
        int l = 0;
        int sum = 0;

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        HashSet<ArrayList<Integer>> resultsSet = new HashSet<>();

        for (int i = 0; i < n; ++i){
            for (int j = i+1; j < n; ++j){
                k = j + 1;
                l = n - 1;

                while (k < l){
                    sum = arr.get(i) + arr.get(j) + arr.get(k) + arr.get(l);
                    if (sum < target)
                        ++k;
                    else if (sum > target)
                        --l;
                    else {
                        ArrayList<Integer> res_single = new ArrayList<>();
                        res_single.add(arr.get(i));
                        res_single.add(arr.get(j));
                        res_single.add(arr.get(k));
                        res_single.add(arr.get(l));
                        if (!resultsSet.contains(res_single)){
                            resultsSet.add(res_single);
                            results.add(res_single);
                        }
                        ++k;
                        --l;
                    }
                }
            }
        }

        return results;
    }
}
