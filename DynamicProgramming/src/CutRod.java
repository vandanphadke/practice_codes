import java.util.Arrays;

/*
*  Q: https://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
*  Solution: Current implementation is the bottom-up DP solution
* */


public class CutRod {
    public static void main(String[] args){
        int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(getMaxRevenue(prices, 8));

    }

    public static int getMaxRevenue(int[] prices, int length){
        int[] revenue = new int[length + 1];
        revenue[0] = 0;
        revenue[1] = prices[1];

        for (int i = 2; i <= length; i++) {
            int l = i;
            int maxRevenue = Integer.MIN_VALUE;

            for (int j = 1; j <= l; ++j){
                if (maxRevenue < (prices[j] + revenue[l - j]))
                    maxRevenue = (prices[j] + revenue[l - j]);
            }
            revenue[i] = maxRevenue;
        }

        System.out.println(Arrays.toString(revenue));
        return revenue[length];
    }
}
