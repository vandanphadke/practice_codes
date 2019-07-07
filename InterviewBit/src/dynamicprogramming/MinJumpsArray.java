package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example :
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
 * from index 0 to 1, then 3 steps to the last index.)
 *
 * If it is not possible to reach the end index, return -1.
 *
 */
public class MinJumpsArray {

    public static void main(String[] args){
        List<Integer> jumps = new ArrayList<>();
        jumps.add(2);jumps.add(3);jumps.add(1);jumps.add(1);jumps.add(4);
        System.out.println(getMinJumpsArray(jumps));
    }

    public static int getMinJumpsArray(List<Integer> jumps){
        int[] minJumps = new int[jumps.size()];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;
        for (int i = 0; i < jumps.size(); ++i){
            if (minJumps[i] != Integer.MAX_VALUE){
                for (int j = 1; j <= jumps.get(i); ++j){
                    if ((i + j) < jumps.size()){
                        int index = i + j;
                        minJumps[index] = Math.min(minJumps[index], minJumps[i] + 1);
                    }
                    else
                        break;
                }
            }
            //System.out.println(Arrays.toString(minJumps));
            //break;
        }


        if (minJumps[minJumps.length - 1] == Integer.MAX_VALUE) return -1;
        return minJumps[minJumps.length - 1];
    }

    public static int getMinJumpsArrayEfficient(List<Integer> jump){
        int step = jump.get(0);
        int maxReach = jump.get(0);
        int jumps = 1;

        for (int i = 0; i < jump.size(); ++i){
            if (i == jump.size() - 1)
                return jumps;

            maxReach = Math.max(maxReach, jump.get(i) + i);
            --step;

            if (step == 0){
                ++jumps;
                if (i >= maxReach){
                    return -1;
                }
                step = maxReach - i;
            }
        }
        return -1;
    }


}
