import java.util.Arrays;

public class BurstBaloons {
    public static void main(String[] args){
        int[] balloons = {3, 1, 5, 8};
        System.out.println(maxCoins(balloons));
    }


    public static int maxCoins(int[] balloons) {
        int n = balloons.length;
        int[][] dp = new int[n][n];

        for (int len = 1; len <= n; ++len){
            for (int i = 0; i <= n - len; ++i){
                int j = i + len - 1;
                int lValue = 1, rValue = 1;
                if (i != 0)
                    lValue = balloons[i-1];
                if (j != n-1)
                    rValue = balloons[j+1];
                for (int k = i; k <= j; ++k){
                    int before = 0, after = 0;
                    if (i != k){
                        before = dp[i][k-1];
                    }
                    if (j != k){
                        after = dp[k+1][j];
                    }
                    dp[i][j] = Math.max(dp[i][j],
                            (lValue * balloons[k] * rValue) + before + after);
                }
            }
        }
        return dp[0][n-1];
    }
}
