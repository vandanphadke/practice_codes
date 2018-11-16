import java.util.Arrays;

public class OverlappingIntervals {

    static class Interval implements Comparable<Interval>{
        int start;
        int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval interval) {
            if (this.start < interval.start)
                return -1;
            if (this.start == interval.start)
                return 0;
            return 1;
        }
    }

    public static void main(String[] args){

        Interval[] intervals = new Interval[]{new Interval(1, 3),
                new Interval(5, 7),
                new Interval(2, 4),
                new Interval(6, 8)};


        int max_end = 0;
        for (Interval interval: intervals){
            if (interval.end > max_end)
                max_end = interval.end;
        }

        int[] arr = new int[max_end + 2];
        for (int i = 0; i < intervals.length; ++i){
            arr[intervals[i].start]++;
            arr[intervals[i].end + 1]--;
        }

        for (int i = 1; i < max_end; ++i){
            arr[i] += arr[i-1];

            if (arr[i] > 1)
                System.out.println(true);
        }

        System.out.println(false);

    }

}
