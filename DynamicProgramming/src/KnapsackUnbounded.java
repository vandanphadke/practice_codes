/**
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti,
 * we need to calculate minimum amount that could make up this quantity exactly.
 * This is different from classical Knapsack problem,
 * here we are allowed to use unlimited number of instances of an item.
 *
 * @author vandan
 */
public class KnapsackUnbounded {

    public static void main(String[] args){

        int[] w = {1, 3, 4, 5};
        int[] val = {10, 40, 50, 70};
        int W = 8;
        System.out.println(maxVal(w, val, W));
    }

    public static int maxVal(int[] w, int[] val, int W){
        int[] dp = new int[W + 1];

        for (int i = 0 ; i <= W; ++i){
            for (int j = 0 ; j < w.length; ++j){
                if (w[j] < i)
                    dp[i] = Math.max(dp[i], dp[i - w[j]] + val[j]);
            }
        }
        return dp[W];
    }

}