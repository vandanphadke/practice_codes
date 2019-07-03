package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
 *
 * Make sure the combinations are sorted.
 *
 * To elaborate,
 *
 * Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
 * Entries should be sorted within themselves.
 * Example :
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [1,2],
 *   [1,3],
 *   [1,4],
 *   [2,3],
 *   [2,4],
 *   [3,4],
 * ]
 */
public class Combinations {

    public static void main(String[] args){
        System.out.println(getAllSubsets(4, 2));
    }

    public static ArrayList<ArrayList<Integer>> getAllSubsets(int n, int k){

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        for (int i = 0; i < (1<<n); i++)
        {
            ArrayList<Integer> res = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) > 0)
                    res.add(j + 1);
            }

            if (res.size() == k)
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
