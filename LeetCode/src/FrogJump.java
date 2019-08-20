import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A frog is crossing a river. The river is divided into x units and at each unit there
 * may or may not exist a stone. The frog can jump on a stone, but it must not jump into
 * the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the
 * frog is able to cross the river by landing on the last stone. Initially, the frog is on
 * the first stone and assume the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1
 * units. Note that the frog can only jump in the forward direction.
 *
 * Note:
 *
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 * Example 1:
 *
 * [0,1,3,5,6,8,12,17]
 *
 * There are a total of 8 stones.
 * The first stone at the 0th unit, second stone at the 1st unit,
 * third stone at the 3rd unit, and so on...
 * The last stone at the 17th unit.
 *
 * Return true. The frog can jump to the last stone by jumping
 * 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 * 2 units to the 4th stone, then 3 units to the 6th stone,
 * 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 *
 * [0,1,2,3,4,8,9,11]
 *
 * Return false. There is no way to jump to the last stone as
 * the gap between the 5th and 6th stone is too large.
 */
public class FrogJump {
    public static void main(String[] args){
        int[] stones1 = {0,1,2,3,4,8,9,11};
        System.out.println(canCross(stones1));

        int[] stones2 = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones2));

        int[] stones3 = {0,1,3,6,10,13,15,18};
        System.out.println(canCross(stones3));
    }


    public static boolean canCross(int[] stones) {
        int n = stones.length;
        if (n == 0) return false;

        List<Set<Integer>> jumpsLen = new ArrayList<>();
        for (int i = 0; i < n; ++i){
            jumpsLen.add(new HashSet<>());
        }
        if (stones[1] != 1) return false;
        jumpsLen.get(1).add(1);
        for (int i = 1; i < n; ++i){
            Set<Integer> possible = jumpsLen.get(i);
            for (int jump : possible){
                for (int j = i+1; j < n; ++j){
                    int dist = stones[j] - stones[i];
                    if(dist > jump + 1){
                        break;
                    }
                    if (dist >= jump - 1 && dist <= jump + 1){
                        jumpsLen.get(j).add(dist);
                    }
                }
            }
        }
        return !jumpsLen.get(n-1).isEmpty();
    }
}
