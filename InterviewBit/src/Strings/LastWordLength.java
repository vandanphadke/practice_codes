package Strings;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Given s = "Hello World",
 *
 * return 5 as length("World") = 5.
 *
 * Please make sure you try to solve this problem without using library functions.
 * Make sure you only traverse the string once.
 */
public class LastWordLength {

    public int getLastWordLength(String s){
        s = s.trim();
        int i = s.length() - 1, count = 0;
        while (i >= 0 && s.charAt(i) != ' '){
            ++count;
        }
        return count;
    }

}
