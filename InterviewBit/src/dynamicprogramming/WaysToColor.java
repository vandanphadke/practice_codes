package dynamicprogramming;

/**
 * Given a 3Xn board, find the number of ways to color it using at
 * most 4 colors such that no two adjacent boxes have same color.
 * Diagonal neighbors are not treated as adjacent boxes.
 * Output the ways%1000000007 as the answer grows quickly.
 *
 * 1<= n < 100000
 *
 * Example:
 * Input: n = 1
 * Output: 36
 */
public class WaysToColor {
    public static int getWaysColor(int n){
        long color3 = 24; // When we to fill single column
        long color2 = 12;
        long temp = 0;
        for (int i = 2; i <= n; i++)
        {
            temp = color3;
            color3 = (11 * color3 + 10 * color2 ) % 1000000007;
            color2 = ( 5 * temp + 7 * color2 ) % 1000000007;
        }
        long num = (color3 + color2) % 1000000007;
        return (int)num;
    }
}
