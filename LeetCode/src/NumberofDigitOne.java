import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers
 * less than or equal to n.
 * Example:
 *
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */
public class NumberofDigitOne {
    public static void main(String[] args){
        getNum1s(13);
    }


    public static int getNum1s(int n){
        Queue<Integer> numQueue = new LinkedList<>();
        numQueue.add(1);
        Set<Integer> res = new HashSet<>();
        while (!numQueue.isEmpty() && numQueue.peek() <= n){
            System.out.println(numQueue);
            int cur = numQueue.poll();
            for (int i = 0; i <= 9; ++i){
                numQueue.add(cur * 10 + i);
            }
            int digit = countDigit(cur);
            for (int i = 1; i <= 9; ++i){
                numQueue.add(((digit) * 10 * i) + cur);
            }
        }
        return res.size();
    }

    private static int countDigit(long n) {
        return (int)Math.floor(Math.log10(n) + 1);
    }
}
