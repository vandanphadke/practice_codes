package heaps;

import java.util.Arrays;

/**
 * How many distinct Max Heap can be made from n distinct integers
 *
 * In short, you have to ensure the following properties for the max heap :
 *
 * Heap has to be a complete binary tree ( A complete binary tree is a binary
 * tree in which every level, except possibly the last, is completely filled,
 * and all nodes are as far left as possible. )
 *
 * Every node is greater than all its children
 * Let us take an example of 4 distinct integers.
 * Without loss of generality let us take 1 2 3 4 as our 4 distinct integers
 *
 * Following are the possible max heaps from these 4 numbers :
 *
 *          4
 *        /  \
 *       3   2
 *      /
 *     1
 *          4
 *        /  \
 *       2   3
 *      /
 *     1
 *         4
 *        /  \
 *       3   1
 *      /
 *     2
 * These are the only possible 3 distinct max heaps possible for 4 distinct elements.
 *
 * Implement the below function to return the number of distinct Max Heaps
 * that is possible from n distinct elements.
 *
 * As the final answer can be very large output your answer modulo 1000000007
 *
 * Input Constraints : n <= 100
 *
 *
 */
public class WaysToFormMaxHeap {

    public static void main(String[] args){
        System.out.println(getNumHeapsMain(10));
        System.out.println(getNumberLeftSubtree(10));
    }

    public static int getNumHeapsMain(int n){
        int[][] comb = new int[100][100];
        int[] dp = new int[n+1];
        for (int i = 0; i < 100; ++i)
            Arrays.fill(comb[i], -1);
        Arrays.fill(dp, -1);
        return getNumberofHeapsRecurse(n, dp, comb);
    }

    public static int getLog2(int x){
        return (int)(Math.log(x)/Math.log(2));
    }

    public static int getNumberLeftSubtree(int n){
        if (n == 1) return 0;
        int h = getLog2(n);
        double max = Math.pow(2, h);
        double last = n - (Math.pow(2, h) - 1);
        if (last >= (max/2)){
            return (int)Math.pow(2, h) - 1;
        }
        else {
            return (int)(Math.pow(2, h) - 1 - ((max / 2) - last));
        }
    }

    public static int getCombinations(int n, int k, int[][] comb){
        if (k > n) return 0;
        if (n <= 1 || k == 0) return 1;
        if (comb[n][k] != -1) return comb[n][k];
        int ans = getCombinations(n - 1, k-1, comb)
                + getCombinations(n - 1, k, comb);
        comb[n][k] = ans;
        return ans;
    }

    public static int getNumberofHeapsRecurse(int n, int[] dp, int[][] comb){
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        int left = getNumberLeftSubtree(n);
        int ans = getCombinations(n-1, left, comb) * getNumberofHeapsRecurse(left, dp, comb)
                * getNumberofHeapsRecurse(n - left - 1, dp, comb);
        dp[n] = ans;
        return dp[n];
    }

}
