package BinarySearch;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * If x is not a perfect square, return floor(sqrt(x))
 *
 * Example :
 *
 * Input : 11
 * Output : 3
 */
public class SquareRootInteger {

    public static void main(String[] args){
        System.out.println(getSquareRoot(Integer.MAX_VALUE));
    }

    public static int getSquareRoot(int num){
        if (num == 0) return 0;
        long low = 1, high = num / 2 + 1;
        while (low <= high){
            long mid = (low + high)/ 2;
            long midSq = mid * mid;
            if (midSq == num) return (int)mid;
            else if (midSq < num) low = mid + 1;
            else high = mid - 1;
        }
        return (int)high;
    }

}
