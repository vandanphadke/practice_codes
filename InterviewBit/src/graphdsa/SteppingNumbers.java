package graphdsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given N and M find all stepping numbers in range N to M
 *
 * The stepping number:
 *
 * A number is called as a stepping number if the adjacent digits have a difference of 1.
 * e.g 123 is stepping number, but 358 is not a stepping number
 *
 * Example:
 *
 * N = 10, M = 20
 * all stepping numbers are 10 , 12
 * Return the numbers in sorted order.
 */
public class SteppingNumbers {
    public static void main(String[] args){
        System.out.println(getSteppingNumbers(10, 25));
    }

    public static ArrayList<Integer> getSteppingNumbers(int start, int end){
        Queue<Integer> steppingNos = new LinkedList<>();
        for (int i = 1; i <= 9; ++i){
            steppingNos.add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();

        if(start == 0)
            result.add(0);

        while (steppingNos.peek() <= end){
            int num = steppingNos.poll();
            if (num >= start) {
                result.add(num);
            }
            int prev = getNextBackwardSteppingNumber(num);
            if (prev != -1)
                steppingNos.add(prev);
            int next = getNextForwardSteppingNumber(num);
            if (next != -1)
                steppingNos.add(next);
        }
        return result;
    }

    public static int getNextForwardSteppingNumber(int n){
        int lastDigit = n % 10;
        if (lastDigit == 9) return -1;
        return n * 10 + (lastDigit + 1);
    }

    public static int getNextBackwardSteppingNumber(int n){
        int lastDigit = n % 10;
        if (lastDigit == 0) return -1;
        return n * 10 + (lastDigit - 1);
    }


}
