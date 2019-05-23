import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 */
public class MergeIntervals {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Interval> intervals = new ArrayList<>();
        for (int i = 0 ; i < n; ++i){
            String[] contents = br.readLine().split(" ");
            intervals.add(new Interval(Integer.parseInt(contents[0]), Integer.parseInt(contents[1])));
        }

        String[] contents = br.readLine().split(" ");
        Interval newInterval = new Interval(Integer.parseInt(contents[0]), Integer.parseInt(contents[1]));

        combineIntervals(intervals, newInterval);

    }

    private static ArrayList<Interval> combineIntervals(ArrayList<Interval> intervals, Interval newInterval) {
        if(newInterval.end < intervals.get(0).start){
            intervals.add(0, newInterval);
            return intervals;
        }
        else if(newInterval.start > intervals.get(intervals.size() - 1).end){
            intervals.add(newInterval);
            return intervals;
        }
        else if((newInterval.start < intervals.get(0).start) &&
                (newInterval.start > intervals.get(intervals.size() - 1).end)){
            ArrayList<Interval> result = new ArrayList<>();
            result.add(newInterval);
            return result;
        }

        int i = 0;
        while (i < intervals.size()){
            if ((intervals.get(i).end > newInterval.start) && (intervals.get(i+1).start < newInterval.end)){
                intervals.add(i, newInterval);
                return intervals;
            }


            ++i;
        }


        return null;

    }


}

class Interval {
    int start;
    int end;

    public Interval(int s, int t){
        this.start = s;
        this.end = t;
    }
}