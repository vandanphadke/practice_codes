package Math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 * Example :
 *
 * n = 5
 * n! = 120
 * Number of trailing zeros = 1
 * So, return 1
 *
 */
public class TrailingZerosInFactorial {

    public int getFactorialZeroes(int num){
        int count = 0;

        for (int i = 5; num / i >= 1; i *= 5)
            count += num / i;

        return count;
    }




}
