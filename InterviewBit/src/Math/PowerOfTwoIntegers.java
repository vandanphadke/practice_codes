package Math;

import java.sql.SQLOutput;

/**
 * Given a positive integer which fits in a 32 bit signed integer,
 * find if it can be expressed as A^P where P > 1 and A > 0.
 *
 * A and P both should be integers.
 *
 * Example
 *
 * Input : 4
 * Output : True
 * as 2^2 = 4.
 *
 */
public class PowerOfTwoIntegers {

    public static void main(String[] args){
        System.out.println(checkPowerMine(102400));
        System.out.println(320 * 320);
    }

    /**
     * This method will not work because take the case of:
     * 102400
     *
     * This is 2^12 and 5^2 so this method will give false
     * but it can also be written as 320^2
     *
     */
    public static boolean checkPowerMine(int num){
        int current = 2;
        int pow = 0;

        while (num > 1){
            int count = 0;
            while (num % current == 0){
                ++count;
                num = num / current;
            }
            System.out.println("Current is " + current + " Count is " + count + " Num is " + num);
            if (pow == 0){
                pow = count;
            }
            else {
                if (count != 0 && count != pow){
                    return false;
                }
            }
            ++current;
        }
        return true;
    }

    /*
    * x = A ^ p
    * p = log(x) / log(A)
    * Iff log(x)/log(A) is an integer will p be an integer
    * So we loop over A to check
    * */
    public static boolean checkPowerEfficient(int num){
        if (num == 1) return true;

        double numD = num;
        for (int i = 2; i <= Math.sqrt(num); ++i){
            double rem = Math.log(num) / Math.log(i);
            if (rem - (int) rem < 0.000000001)
                return true;
        }

        return false;
    }

}
