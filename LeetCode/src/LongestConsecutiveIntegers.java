import java.util.HashSet;
import java.util.List;

public class LongestConsecutiveIntegers {

    public int longestConsecutive(final List<Integer> A) {

        if (A.size() == 0)
            return 0;

        HashSet<Integer> intSet = new HashSet<>();
        int maxCount = 1;

        for(int num: A){
            intSet.add(num);
        }

        for(int num: A){
            int l = num - 1;
            int r = num + 1;
            int count = 1;

            while(intSet.contains(l)){
                ++count;
                intSet.remove(l);
                --l;
            }

            while(intSet.contains(r)){
                ++count;
                intSet.remove(r);
                ++r;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;

    }

}
