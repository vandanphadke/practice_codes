package hashing;

import java.util.*;

/**
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array
 *
 * Note:
 *
 * 1) Return the indices `A1 B1 C1 D1`, so that
 *   A[A1] + A[B1] = A[C1] + A[D1]
 *   A1 < B1, C1 < D1
 *   A1 < C1, B1 != D1, B1 != C1
 *
 * 2) If there are more than one solutions,
 *    then return the tuple of values which are lexicographical smallest.
 *
 * Assume we have two solutions
 * S1 : A1 B1 C1 D1 ( these are values of indices int the array )
 * S2 : A2 B2 C2 D2
 *
 * S1 is lexicographically smaller than S2 iff
 *   A1 < A2 OR
 *   A1 = A2 AND B1 < B2 OR
 *   A1 = A2 AND B1 = B2 AND C1 < C2 OR
 *   A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
 */
public class Equal {
    static class Pair {
        int a;
        int b;

        public Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    public static ArrayList<Integer> getPairs(List<Integer> arr){
        HashMap<Integer, Pair> sumMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.size(); ++i){
            for (int j = i + 1; j < arr.size(); ++j){
                int sum = arr.get(i) + arr.get(j);
                if (!sumMap.containsKey(sum)){
                    sumMap.put(sum, new Pair(i, j));
                }
                else {
                    int a = sumMap.get(sum).a;
                    int b = sumMap.get(sum).b;
                    int c = i;
                    int d = j;

                    if (a < b && c < d && a < c && b != d && b != c){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(sumMap.get(sum).a);
                        temp.add(sumMap.get(sum).b);
                        temp.add(i);
                        temp.add(j);
                        result.add(temp);
                    }
                }
            }
        }

        Collections.sort(result, Comparator.comparingInt((ArrayList<Integer> o) -> o.get(0))
                .thenComparingInt(o -> o.get(1))
                .thenComparingInt(o -> o.get(2))
                .thenComparingInt(o -> o.get(3)));

        return result.get(0);
    }
}
