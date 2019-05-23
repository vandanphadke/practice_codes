package Arrays;

import java.util.ArrayList;

/**
 * Q: You are given a binary string(i.e. with characters 0 and 1)
 * S consisting of characters S1, S2, …, SN.
 * In a single operation, you can choose two indices L and R
 * such that 1 ≤ L ≤ R ≤ N and flip
 * the characters SL, SL+1, …, SR.
 *
 * By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final
 * string number of 1s is maximised. If you don’t want to perform
 * the operation, return an empty array.
 * Else, return an array consisting of two elements
 * denoting L and R.
 * If there are multiple solutions,
 * return the lexicographically smallest pair of L and R.
 *
 * S = 010
 *
 * Pair of [L, R] | Final string
 * _______________|_____________
 * [1 1]          | 110
 * [1 2]          | 100
 * [1 3]          | 101
 * [2 2]          | 000
 * [2 3]          | 001
 *
 * We see that two pairs [1, 1] and [1, 3]
 * give same number of 1s in final string. So, we return [1, 1].
 *
 */
public class Flip {

    public static void main(String[] args){
        String s = "101";
        flipDigits(s);
        String s1 = "000001000";
        flipDigits(s1);
    }

    public static ArrayList<Integer> flipDigits(String s){
        int count = 0;
        int i = 0, j = 0;
        char[] sCharArr = s.toCharArray();
        int maxi = Integer.MIN_VALUE;
        int maxj = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;

        while (j < sCharArr.length){
            i = j;
            count = 0;
            while (j < sCharArr.length && count >= 0){
                if (sCharArr[j] == '0') {
                    ++count;
                    if (count > maxCount) {
                        maxCount = count;
                        maxi = i;
                        maxj = j;
                    }
                }
                else
                    --count;
                ++j;
            }
        }
        ArrayList<Integer> results = new ArrayList<>();
        if (maxi >= 0){
            results.add(maxi);
            results.add(maxj);
        }

        return results;
    }
}
