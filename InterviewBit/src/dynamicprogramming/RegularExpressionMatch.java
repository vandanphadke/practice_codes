package dynamicprogramming;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' : Matches any single character.
 * '*' : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 *
 * int isMatch(const char *s, const char *p)
 * Examples :
 *
 * isMatch("aa","a") → 0
 * isMatch("aa","aa") → 1
 * isMatch("aaa","aa") → 0
 * isMatch("aa", "*") → 1
 * isMatch("aa", "a*") → 1
 * isMatch("ab", "?*") → 1
 * isMatch("aab", "c*a*b") → 0
 * Return 1/0 for this problem.
 */
public class RegularExpressionMatch {
    public int doesTextMatch(String str, String pattern){
        int n = str.length(), m = pattern.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[n][m] = true;
        return 0;
    }
}
