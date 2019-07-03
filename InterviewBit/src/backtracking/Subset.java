package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The list is not necessarily sorted.
 * Example :
 *
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [],
 *   [1],
 *   [1, 2],
 *   [1, 2, 3],
 *   [1, 3],
 *   [2],
 *   [2, 3],
 *   [3],
 * ]
 */
public class Subset {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);arr.add(2);arr.add(3);
        System.out.println(getAllSubsets(arr));
    }


    public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> nums){
        int n = nums.size();

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        for (int i = 0; i < (1<<n); i++)
        {
            ArrayList<Integer> res = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) > 0)
                    res.add(nums.get(j));
            }
            results.add(res);
        }

        Collections.sort(results, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });


        return results;
    }




}
