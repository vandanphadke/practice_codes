package BinarySearch;

/**
 * Implement pow(x, n) % d.
 *
 * In other words, given x, n and d,
 *
 * find (xn % d)
 *
 * Note that remainders on division cannot be negative.
 * In other words, make sure the answer you return is non negative.
 *
 * Input : x = 2, n = 3, d = 3
 * Output : 2
 *
 * 2^3 % 3 = 8 % 3 = 2.
 */
public class ImplementPowerFunction {

    public static void main(String[] args){
        System.out.println(getPower(2312, 3434, 6789));
        System.out.println(getPower(3, 3, 20));
    }

    public static int getPower(int x, int n, int d){
        if (x == 0) return 0;
        if (n == 0) return 1;

        int res = 0;
        if ((n % 2) == 0){
            res = getPower(x, n/2, d);
            res = (res * res) % d;
        }
        else {
            res = x % d;
            res = (res * (getPower(x, n-1, d) % d) % d);
        }
        return (res + d) % d;
    }


}
