package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * Example:
 *
 * [1,2,3] will have the following permutations:
 *
 * [1,2,3]
 * [1,3,2]
 * [2,1,3]
 * [2,3,1]
 * [3,1,2]
 * [3,2,1]
 *  NOTE
 * No two entries in the permutation sequence should be the same.
 * For the purpose of this problem, assume that all the numbers in the collection are unique.
 */
public class Permutations {
    public static void main(String[] args){
        List<Integer> arr = Arrays.asList(1, 2, 3);
        generatePermutations(arr);
    }

    public static ArrayList<ArrayList<Integer>> generatePermutations(List<Integer> arr){
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        genRecurse(arr, 0, arr.size() - 1, results);
        System.out.println(results);
        return results;
    }

    public static void genRecurse(List<Integer> arr, int l, int r, ArrayList<ArrayList<Integer>> result){
        if (l == r){
            result.add(new ArrayList<>(arr));
            return;
        }
        else {
            for (int i = l; i <= r; ++i){
                swap(arr, i, l);
                genRecurse(arr, l+1, r, result);
                swap(arr, i, l);
            }
        }
    }

    public static void swap(List<Integer> arr, int indexA, int indexB){
        int temp = arr.get(indexA);
        arr.set(indexA, arr.get(indexB));
        arr.set(indexB, temp);
    }
}
