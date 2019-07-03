package stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram’s
 * bar height where the width of each bar is 1, find the area
 * of largest rectangle in the histogram.
 *
 * Largest Rectangle in Histogram: Example 1
 *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 *
 * Largest Rectangle in Histogram: Example 2
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);arr.add(2);arr.add(5);arr.add(4);
        arr.add(5);arr.add(1);arr.add(6);
        System.out.println(getLargestArea(arr));
    }


    public static int getLargestArea(ArrayList<Integer> heights){
        Stack<Integer> indexes = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        while (i < heights.size()){
            if ((indexes.isEmpty()) || (heights.get(indexes.peek()) < heights.get(i))){
                indexes.push(i);
                ++i;
            }
            else {
                int top = indexes.pop();
                int currentArea = heights.get(top) * (indexes.isEmpty() ? i : i - indexes.peek() - 1);
                if (maxArea < currentArea)
                    maxArea = currentArea;
            }
        }

        while (!indexes.isEmpty()){
            int top = indexes.pop();
            int currentArea = heights.get(top) * (indexes.isEmpty() ? i : i - indexes.peek() - 1);
            if (maxArea < currentArea )
                maxArea = currentArea;
        }

        return maxArea;
    }

}
