package Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

/**
 * Given a set of non-overlapping intervals, insert a new interval into
 * the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 *
 * Example 2:
 *
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result
 * in [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * Make sure the returned intervals are also sorted.
 *
 */
public class MergeIntervals {

    static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return start + "   " + end;
        }
    }

    public static void main(String[] args){
        ArrayList<Interval> in = new ArrayList<>();
        in.add(new Interval(1, 3));
        in.add(new Interval(6, 9));

        System.out.println(insert(in, new Interval(2, 5)));
    }


    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
        intervals.add(newInterval);
        intervals.sort(Comparator.comparingInt(i -> i.start));
        Stack<Interval> intervalStack = new Stack<>();

        for (int i = 0; i < intervals.size(); ++i){
            if (intervalStack.isEmpty()){
                intervalStack.push(intervals.get(i));
            }
            else {
                Interval last = intervalStack.peek();
                Interval current = intervals.get(i);
                if (canMergeIntervals(last, current)){
                    intervalStack.pop();
                    intervalStack.push(new Interval(Math.min(last.start, current.start),
                            Math.max(last.end, current.end)));
                }
                else {
                    intervalStack.push(intervals.get(i));
                }
            }
        }
        ArrayList<Interval> results = new ArrayList<>();
        while (!intervalStack.isEmpty()){
            results.add(0, intervalStack.pop());
        }

        return results;
    }

    public static boolean canMergeIntervals(Interval interval1, Interval interval2){
        if (interval2.start < interval1.end){
            return true;
        }
        else
            return false;
    }

}
