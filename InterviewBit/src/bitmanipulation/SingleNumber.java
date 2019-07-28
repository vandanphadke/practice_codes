package bitmanipulation;

import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * Example :
 *
 * Input : [1 2 2 3 1]
 * Output : 3
 */
public class SingleNumber {
    public static int singleNumber(final List<Integer> a) {
        int result = a.get(0);
        for(int i = 1; i < a.size(); i++){
            result ^= a.get(i);
        }
        return result;
    }
}
