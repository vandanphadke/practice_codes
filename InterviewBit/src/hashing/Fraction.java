package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the
 * fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example :
 *
 * Given numerator = 1, denominator = 2, return "0.5"
 * Given numerator = 2, denominator = 1, return "2"
 * Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class Fraction {
    public static void main(String[] args){
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(972, 67));
        System.out.println(fractionToDecimal(-2147483648, -1));
    }


    public static String fractionToDecimal(int num, int denom) {
        long numerator = (long) num;
        long denominator = (long) denom;
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator < 0) ^ (denominator < 0)) ? "-" : "");
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long leftPart = Math.abs((long)numerator / denominator);
        numerator = numerator % denominator;
        sb.append(leftPart);
        if (numerator == 0) return sb.toString();
        Map<Long, Integer> remMap = new HashMap<>();
        sb.append(".");
        remMap.put(numerator, sb.length());
        while (numerator != 0){
            numerator = numerator * 10;
            long quotient = numerator / denominator;
            sb.append(quotient);
            numerator = numerator % denominator;
            if (remMap.containsKey(numerator)){
                int index = remMap.get(numerator);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            else {
                remMap.put(numerator, sb.length());
            }
        }
        return sb.toString();
    }
}
