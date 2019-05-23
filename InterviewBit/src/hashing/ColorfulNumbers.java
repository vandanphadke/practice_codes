package hashing;

import java.util.HashSet;

/**
 * For Given Number N find if its COLORFUL number or not
 *
 * Return 0/1
 *
 * COLORFUL number:
 *
 * A number can be broken into different contiguous sub-subsequence parts.
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * And this number is a COLORFUL number, since product of every digit of a
 * contiguous subsequence is different
 *
 * Example:
 *
 * N = 23
 * 2 3 23
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6
 * this number is a COLORFUL number since product of
 * every digit of a sub-sequence are different.
 *
 * Output : 1
 *
 */
public class ColorfulNumbers {

    public static void main(String[] args){
        System.out.println(checkColorfulNumber(2345));
        System.out.println(checkColorfulNumber(23));
    }


    public static int checkColorfulNumber(int number){
        char[] numChar = (number + "").toCharArray();
        HashSet<Integer> sums = new HashSet<>();
        int[] numIntRepr = new int[numChar.length];

        for (int i = 0; i < numChar.length; ++i){
            numIntRepr[i] = numChar[i] - '0';
        }

        for (int l = 1; l <= numChar.length; ++l){
            for (int i = 0; i < numChar.length - l + 1; ++i){
                int currentProd = 1;
                for (int j = i; j < i + l; ++j){
                    currentProd = currentProd * numIntRepr[j];
                }
                if (sums.contains(currentProd))
                    return 0;
                else
                    sums.add(currentProd);
            }
        }

        return 1;
    }
}
