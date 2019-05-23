package dynamicprogramming;

/**
 * Given a number N, return number of ways you can draw
 * N chords in a circle with 2*N points such that no 2 chords intersect.
 *
 * Two ways are different if there exists a chord which is present in one way and not in other.
 *
 * For example,
 *
 * N=2
 * If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:
 * {(1-2), (3-4)} and {(1-4), (2-3)}
 *
 * So, we return 2.
 *
 */
public class IntersectingChordsInCircle {

    public static void main(String[] args){
        System.out.println(getNumberOfWays(2));
        System.out.println(getNumberOfWays(1));
        System.out.println(getNumberOfWays(4));
    }

    public static int getNumberOfWays(int n){
        final int MOD = 1000000007;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; ++i){
            for (int j = 0; j < i ; ++j){
                dp[i] += (dp[j] * dp[i - 1 - j] % MOD) % MOD;
            }
        }

        return dp[n] % MOD;
    }

}
