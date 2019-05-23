package Strings;

/**
 * Implement strStr().
 *
 *  strstr - locate a substring ( needle ) in a string ( haystack ).
 * Try not to use standard library string functions for this question.
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {

    public static void main(String[] args){
        System.out.println(strStr("abcdabcdef", "def"));
    }

    public static int strStr(String h, String n){
        char[] haystack = h.toCharArray();
        char[] needle = n.toCharArray();

        int[] lps = computeLps(needle);
        int i = 0, j = 0;
        while (i < haystack.length && j < needle.length){
            if (haystack[i] == needle[j]){
                ++i;
                ++j;
            }
            else {
                if (j != 0){
                    j = lps[j-1];
                }
                else {
                    ++i;
                }
            }
        }
        if (j == needle.length)
            return (i-j);
        else
            return -1;
    }

    public static int[] computeLps(char[] pattern){
        int i = 1, j= 0;
        int[] lps = new int[pattern.length];

        while (i < pattern.length){
            if (pattern[i] == pattern[j]){
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

}
