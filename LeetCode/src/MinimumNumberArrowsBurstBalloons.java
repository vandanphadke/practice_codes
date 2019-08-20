import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon,
 * provided input is the start and end coordinates of the horizontal diameter. Since it's
 * horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the
 * diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon
 * with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to
 * the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The
 * problem is to find the minimum number of arrows that must be shot to burst all balloons.
 *
 * Example:
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and
 * another arrow at x = 11 (bursting the other two balloons).
 */
public class MinimumNumberArrowsBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        Stack<int[]> segmentStack = new Stack<>();
        segmentStack.push(points[0]);
        for (int i = 1; i < points.length; ++i){
            int[] last = segmentStack.pop();
            int[] current = points[i];
            if (doIntersect(last, current)){
                int[] intersection = getIntersectionLength(last, current);
                segmentStack.push(intersection);
            }
            else {
                segmentStack.push(last);
                segmentStack.push(current);
            }
        }

        return segmentStack.size();
    }
    // second's start is less than first's end
    public boolean doIntersect(int[] seg1, int[] seg2){
        return seg2[0] <= seg1[1];
    }

    public int[] getIntersectionLength(int[] seg1, int[] seg2){
        int[] intersect = new int[2];
        intersect[0] = Math.max(seg1[0], seg2[0]);
        intersect[1] = Math.min(seg1[1], seg2[1]);
        return intersect;
    }
}
