package Strings;

import java.util.Arrays;

/**
 *
 * Given a string S, find the longest palindromic substring in S.
 *
 * Substring of string S:
 *
 * S[i...j] where 0 <= i <= j < len(S)
 *
 * Palindrome string:
 *
 * A string which reads the same backwards. More formally, S is
 * palindrome if reverse(S) = S.
 *
 * Incase of conflict, return the substring which occurs first
 * (with the least starting index).
 *
 * Example :
 *
 * Input : "aaaabaaa"
 * Output : "aaabaaa"
 *
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args){
        System.out.println(getLargestSubstring("aaaabaaa"));
    }

    /* Currently this solution is not working */
    public static String getLargestSubstring(String str){
        int n = str.length();
        int[][] dp = new int[n][n];
        char[] strArr = str.toCharArray();
        int maxlen = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i){
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; ++i){
            if (strArr[i] == strArr[i+1])
                dp[i][i+1] = 2;
        }

        for (int k = 3; k <= n; ++k){
            for (int i = 0; i < n - k + 1; ++i){
                int j = i + k - 1;
                if (strArr[i] == strArr[j]){
                    dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, Math.max(dp[i + 1][j], dp[i][j - 1]));
                }
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > maxlen){
                    maxlen = dp[i][j];
                }
            }
        }

        if (maxlen == 1) return str.substring(0, 1);

        for (int k = 3; k <= n; ++k){
            for (int i = 0; i < n - k + 1; ++i){
                int j = i + k - 1;
                if (dp[i][j] == maxlen)
                    return str.substring(i, j+1);
            }
        }
        return null;
    }


}
