package BinarySearch;

import java.util.List;

/**
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}.
 * There are K painters available and you are also given how
 * much time a painter takes to paint 1 unit of board. You have to
 * get this job done as soon as possible under the constraints
 * that any painter will only paint contiguous sections of board.
 *
 * 2 painters cannot share a board to paint. That is to say, a board
 * cannot be painted partially by one painter, and partially by another.
 * A painter will only paint contiguous boards. Which means a
 * configuration where painter 1 paints board 1 and 3 but not 2 is
 * invalid.
 * Return the ans % 10000003
 *
 * Input :
 * K : Number of painters
 * T : Time taken by painter to paint 1 unit of board
 * L : A List which will represent length of each board
 *
 * Output:
 *      return minimum time to paint all boards % 10000003
 * Example
 *
 * Input :
 *   K : 2
 *   T : 5
 *   L : [1, 10]
 * Output : 50
 */
public class PaintersPartitionerProblem {

    public static int getOptimalPartitions(List<Integer> boards, int k, int t){
        long maxTime = 0;
        long minTime = Integer.MIN_VALUE;
        int n = boards.size();

        for (int i = 0; i < n; ++i) {
            maxTime += boards.get(i);
            minTime = Math.max(boards.get(i), minTime);
        }

        while (minTime < maxTime){
            long midTime = minTime + ((maxTime - minTime)/2);
            long required = getPaintersForTime(boards, midTime);
            if (required <= k){
                maxTime = midTime;
            }
            else
                minTime = midTime + 1;
        }
        return (int)(minTime * t % 10000003);

    }

    public static long getPaintersForTime(List<Integer> boards, long time){
        long current = 1, currentTime = 0;
        for (int i = 0; i < boards.size(); ++i) {
            currentTime += boards.get(i);
            if (currentTime > time){
                ++current;
                currentTime = boards.get(i);
            }
        }
        return current;
    }


}
