package graphdsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * How many minimum numbers from fibonacci series are required such that sum of numbers should be
 * equal to a given Number N? Note : repetition of number is allowed.
 *
 * Example:
 *
 * N = 4
 * Fibonacci numbers : 1 1 2 3 5 .... so on
 * here 2 + 2 = 4
 * so minimum numbers will be 2
 */
public class SumOfFibonacciNumbers {
    public static void main(String[] args){
        System.out.println(getMinFiboNumbersEfficient(4));
    }

    public static int getMinFiboNumbers(int req){
        List<Integer> fibo = new ArrayList<>();
        fibo.add(0);fibo.add(1);
        int sum = Integer.MIN_VALUE;
        while (sum < req){
            sum = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2);
            fibo.add(sum);
        }
        return getMinCoinChange(fibo, req);
    }

    public static int getMinCoinChange(List<Integer> coins, int req){
        int m = coins.size();
        int[] dp = new int[req + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= req; ++i){
            for (int j = 0; j < m; ++j){
                if (i >= coins.get(j)){
                    int res = dp[i - coins.get(j)];
                    if (res != Integer.MAX_VALUE && (res + 1) < dp[i])
                        dp[i] = res + 1;
                }
            }
        }
        return dp[req];
    }

    public static int getMinFiboNumbersEfficient(int req){
        List<Integer> fibo = new ArrayList<>();
        fibo.add(0);fibo.add(1);
        int sum = Integer.MIN_VALUE;
        while (sum < req){
            sum = fibo.get(fibo.size() - 1) + fibo.get(fibo.size() - 2);
            fibo.add(sum);
        }
        return getCoinChangeGreedy(fibo, req);
    }

    public static int getCoinChangeGreedy(List<Integer> fibo, int req){
        int j = fibo.size() - 1;
        int left = req;
        int total = 0;
        while (left != 0){
            int quotient = left / fibo.get(j);
            total += quotient;
            left -= quotient * fibo.get(j);
            --j;
        }
        return total;
    }

}
