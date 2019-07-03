package bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an array of N integers, find the pair of integers in the
 * array which have minimum XOR value. Report the minimum XOR value.
 *
 * Examples :
 * Input
 * 0 2 5 7
 * Output
 * 2 (0 XOR 2)
 * Input
 * 0 4 7 9
 * Output
 * 3 (4 XOR 7)
 *
 */
public class MinXORValue {

    public ArrayList<Integer> getMinXorIntegers(ArrayList<Integer> arr){
        Collections.sort(arr);
        int minXorVal = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < arr.size() - 1; ++i){
            int current = arr.get(i) ^ arr.get(i + 1);
            if (current < minXorVal){
                index = i;
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        results.add(index);
        results.add(index + 1);
        return results;
    }

}
