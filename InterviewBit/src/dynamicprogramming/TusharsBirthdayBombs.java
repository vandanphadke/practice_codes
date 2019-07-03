package dynamicprogramming;

import java.util.ArrayList;

/**
 * It’s Tushar’s birthday today and he has N friends. Friends are numbered [0, 1, 2, …., N-1]
 * and i-th friend have a positive strength S(i). Today being his birthday,
 * his friends have planned to give him birthday bombs (kicks :P).
 * Tushar’s friends know Tushar’s pain bearing limit and would hit accordingly.
 * If Tushar’s resistance is denoted by R (>=0) then find the lexicographically
 * smallest order of friends to kick Tushar so that the cumulative kick strength
 * (sum of the strengths of friends who kicks) doesn’t exceed his
 * resistance capacity and total no. of kicks hit are maximum. Also note that each
 * friend can kick unlimited number of times (If a friend hits x times, his strength
 * will be counted x times)
 *
 *
 * Note:
 * Answer format = Vector of indexes of friends in the order in which they will hit.
 * Answer should have the maximum no. of kicks that can be possibly hit.
 * If two answer have the same no. of kicks, return one with the lexicographically smaller.
 * [a1, a2, …., am] is lexicographically smaller than [b1, b2, .., bm] if a1 < b1
 * or (a1 = b1 and a2 < b+2) … .
 *
 * Input cases are such that the length of the answer does not exceed 100000.
 * Example:
 * R = 11, S = [6,8,5,4,7]
 *
 * ans = [0,2]
 * Here, [2,3], [2,2] or [3,3] also give the maximum no. kicks.
 *
 */
public class TusharsBirthdayBombs {

    public static void main(String[] args){
        ArrayList<Integer> q = new ArrayList<>();
        q.add(6);q.add(8);q.add(5);q.add(4);q.add(7);
        System.out.println(getMaxKicks(q, 11));
    }


    public static ArrayList<Integer> getMaxKicks(ArrayList<Integer> strengths, int resistance){
        int minStrength = Integer.MAX_VALUE;

        for (int strength: strengths){
            if (strength < minStrength)
                minStrength = strength;
        }

        int maxKicks = resistance / minStrength;
        int currentsum = resistance;

        int i = 0;
        int kicksLeft = maxKicks;
        ArrayList<Integer> results = new ArrayList<>();

        while (i < strengths.size() && kicksLeft > 0){
            if (strengths.get(i) == minStrength){
                for (int j = 0; j < kicksLeft; ++j){
                    results.add(i);
                }
                break;
            }

            if ((currentsum - strengths.get(i)) >= ((kicksLeft - 1) * minStrength)){
                currentsum -= strengths.get(i);
                --kicksLeft;
                results.add(i);
            }
            else
                ++i;

        }

        return results;
    }

}
