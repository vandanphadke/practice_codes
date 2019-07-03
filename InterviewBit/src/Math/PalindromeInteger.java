package Math;

/**
 * Check if the given integer is a palindrome
 */
public class PalindromeInteger {

    public static boolean isIntegerPalindrome(int num){
        if (num < 0) return false;

        int temp = num;
        int cmp = 0;

        while (num > 0){
            cmp = (cmp * 10) + num % 10;
            num = num / 10;
        }

        if (cmp == temp) return true;
        return false;
    }


}
