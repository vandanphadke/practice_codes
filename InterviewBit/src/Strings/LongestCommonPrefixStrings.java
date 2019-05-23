package Strings;

import java.util.List;

/**
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Longest common prefix for a pair of strings S1 and S2 is the longest string S which
 * is the prefix of both S1 and S2.
 *
 * As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 *
 * Given the array of strings, you need to find the longest S which is the prefix of
 * ALL the strings in the array.
 *
 */
public class LongestCommonPrefixStrings {

    public String longestCommonPrefixStrings(List<String> strings){
        return longestCommonPrefixRecurse(strings, 0, strings.size() - 1);
    }

    public String longestCommonPrefixRecurse(List<String> strings, int l, int r){
        if (l == r)
            return strings.get(l);

        if (l < r){
            int mid = l + (r - l)/2;
            String prefix1 = longestCommonPrefixRecurse(strings, l, mid);
            String prefix2 = longestCommonPrefixRecurse(strings, mid+1, r);
            return getPrefixTwoStrings(prefix1, prefix2);
        }
        return null;
    }

    public static String getPrefixTwoStrings(String str1, String str2){
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        for (int i = 0, j = 0; i <= n1 - 1 &&
                j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }


}
