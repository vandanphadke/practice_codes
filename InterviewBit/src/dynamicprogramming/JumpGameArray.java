package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return 1 ( true ).
 *
 * A = [3,2,1,0,4], return 0 ( false ).
 *
 * Return 0/1 for this problem
 */
public class JumpGameArray {

    public static int canJump(ArrayList<Integer> jumps){
        //if (jumps.size() <= 1) return 1;
        //if (jumps.get(0) == 0) return 0;


        int[] minJumps = new int[jumps.size()];
        Arrays.fill(minJumps, Integer.MAX_VALUE);

        for (int i = 0; i < jumps.size(); ++i){
            if (jumps.get(i) != Integer.MAX_VALUE){
                for (int j = 1; j <= jumps.get(i); ++j){
                    if ((i + j) < jumps.size()){
                        int index = i + j;
                        minJumps[index] = Math.min(jumps.get(index), jumps.get(i) + 1);
                    }
                    else
                        break;
                }
            }
        }

        //System.out.println(Arrays.toString(minJumps));
        if (minJumps[minJumps.length - 1] == Integer.MAX_VALUE) return 0;
        return 1;
    }

}
