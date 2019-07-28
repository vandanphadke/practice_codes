package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  You are given an array A consisting of strings made up of the letters ‘a’ and ‘b’ only.
 * Each string goes through a number of operations, where:
 *
 * 1.	At time 1, you circularly rotate each string by 1 letter.
 * 2.	At time 2, you circularly rotate the new rotated strings by 2 letters.
 * 3.	At time 3, you circularly rotate the new rotated strings by 3 letters.
 * 4.	At time i, you circularly rotate the new rotated strings by i % length(string) letters.
 *
 * Eg: String is "abaa"
 *
 * 1.	At time 1, string is "baaa", as 1 letter is circularly rotated to the back
 * 2.	At time 2, string is "aaba", as 2 letters of the string "baaa" is circularly rotated to the back
 * 3.	At time 3, string is "aaab", as 3 letters of the string "aaba" is circularly rotated to the back
 * 4.	At time 4, string is again "aaab", as 4 letters of the string "aaab" is circularly rotated to the back
 * 5.	At time 5, string is "aaba", as 1 letters of the string "aaab" is circularly rotated to the back
 * After some units of time, a string becomes equal to it’s original self.
 * Once a string becomes equal to itself, it’s letters start to rotate from the first letter again (process resets).
 * So, if a string takes t time to get back to the original, at time t+1 one letter will be rotated and the string will
 * be it’s original self at 2t time.
 * You have to find the minimum time, where maximum number of strings are equal to their original self.
 * As this time can be very large, give the answer modulo 109+7.
 *
 * Note: Your solution will run on multiple test cases so do clear global variables after using them.
 *
 * Input:
 *
 * A: Array of strings.
 * Output:
 *
 * Minimum time, where maximum number of strings are equal to their original self.
 * Constraints:
 *
 * 1 <= size(A) <= 10^5
 * 1 <= size of each string in A <= 10^5
 * Each string consists of only characters 'a' and 'b'
 * Summation of length of all strings <= 10^7
 * Example:
 *
 * Input
 *
 * A: [a,ababa,aba]
 * Output
 *
 * 4
 *
 * String 'a' is it's original self at time 1, 2, 3 and 4.
 * String 'ababa' is it's original self only at time 4. (ababa => babaa => baaba => babaa => ababa)
 * String 'aba' is it's original self at time 2 and 4. (aba => baa => aba)
 *
 * Hence, 3 strings are their original self at time 4.
 */
public class Stringoholics {

    public static void main(String[] args){
        System.out.println(getNumberOfRotations("abaa"));
    }

    public static int[] constructLpsArray(String pattern){
        int[] lps = new int[pattern.length()];
        int j = 0;
        lps[0] = 0;
        int i = 1;
        while (i < pattern.length()){
            if (pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j + 1;
                ++j;
                ++i;
            }
            else {
                if (j != 0){
                    j = lps[j-1];
                }
                else {
                    lps[i] = 0;
                    ++i;
                }
            }
        }
        return lps;
    }

    public static int matchSubstringIndex(String str, String pattern){
        int[] lps = constructLpsArray(pattern);
        int i = 0, j = 0;
        while (i < str.length() && j < pattern.length()){
            if (str.charAt(i) == pattern.charAt(j)){
                ++i;
                ++j;
            }
            else {
                if (j != 0){
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
        if (j == pattern.length()) return i - j;
        else return 0;
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int getNumberOfRotations(String s){
        String newStr = s.substring(1) + s;
        return 1 + matchSubstringIndex(newStr, s);
    }

    public static int getMinRotationsAll(List<String> strs){
        List<Integer> rotations = new ArrayList<>();
        for (String str : strs){
            rotations.add(getNumberOfRotations(str));
        }

        int ans = rotations.get(0);

        for (int i = 1; i < rotations.get(i); i++)
            ans = (((rotations.get(i) * ans)) /
                    (gcd(rotations.get(i), ans)));

        return ans;
    }

}
