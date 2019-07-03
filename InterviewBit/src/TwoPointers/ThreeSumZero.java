package TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets. For example,
 * given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSumZero {

    public ArrayList<ArrayList<Integer>> getThreeSumElements(List<Integer> arr){

        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        int currentSum = 0;

        for (int i = 0; i < arr.size() - 2; ++i){
            if (i > 0 && arr.get(i).equals(arr.get(i-1))) continue;
            int j = i + 1;
            int k = arr.size() - 1;


            while (j < k){

                currentSum = arr.get(i) + arr.get(j) + arr.get(k);

                if (currentSum == 0){
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(arr.get(i));
                    res.add(arr.get(j));
                    res.add(arr.get(k));
                    results.add(res);
                    ++j;
                    --k;

                    while(j<k && arr.get(j) == arr.get(j-1)) j++;
                    while(j<k && arr.get(k) == arr.get(k+1)) k--;
                }

                if (currentSum < 0) ++j;
                else --k;
            }
        }
        return results;
    }


}
