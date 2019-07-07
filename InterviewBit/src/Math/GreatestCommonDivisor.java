package Math;

/**
 *
 * Given 2 non negative integers m and n, find gcd(m, n)
 *
 * GCD of 2 integers m and n is defined as the greatest integer g
 * such that g is a divisor of both m and n.
 *
 * Both m and n fit in a 32 bit signed integer.
 *
 */
public class GreatestCommonDivisor {

    public int getGCD(int m, int n){
        if (n == 0)
            return m;
        return getGCD(n, m % n);
    }

}
