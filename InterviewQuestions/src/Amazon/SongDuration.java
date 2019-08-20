package Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Input array contains song duration (in minutes). Find two songs which combined play for exactly
 * 3 minutes. If there are multiple possible solutions, select the onw with the maximum index.
 *
 * Solution: This is the 2-Sum problem with a little modification for tie break.
 */
public class SongDuration {
    public int[] getSongs(int[] durations){
        if (durations == null || durations.length == 0) return new int[0];

        Map<Integer, Integer> sumMap = new HashMap<>();
        int ansIndex1 = 0, ansIndex2 = 0;
        sumMap.put(durations[0], 0);
        for (int i = 1; i < durations.length; ++i){

        }
        return new int[0];
    }
}
