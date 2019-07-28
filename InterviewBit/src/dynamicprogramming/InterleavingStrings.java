package dynamicprogramming;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example,
 * Given:
 *
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class InterleavingStrings {
    public static void main(String[] args){
        System.out.println(checkInterleavingStrings("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(checkInterleavingStrings("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static int checkInterleavingStrings(String s1, String s2, String s3){
        int m = s1.length(), n = s2.length(), k = s3.length();
        if (m + n != k) return 0;
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i = 0; i <= m; ++i){
            for (int j = 0; j <= n; ++j){
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (j == 0){
                    if(s1.charAt(i-1) == s3.charAt(i-1))
                        dp[i][j] = dp[i-1][j];
                }
                else if (i == 0) {
                    if (s2.charAt(j-1) == s3.charAt(j-1))
                        dp[i][j] = dp[i][j-1];
                }
                else {
                    if ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) &&
                            (s2.charAt(j - 1) == s3.charAt(i + j - 1))){
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                    else if (s1.charAt(i-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i-1][j];
                    }
                    else if (s2.charAt(j-1) == s3.charAt(i+j-1)){
                        dp[i][j] = dp[i][j-1];
                    }
                    else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n] ? 1 : 0;
    }
}
