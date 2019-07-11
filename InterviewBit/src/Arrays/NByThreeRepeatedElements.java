package Arrays;

import java.util.List;

/**
 * You’re given a read only array of n integers. Find out if any
 * integer occurs more than n/3 times in the array in linear time
 * and constant additional space.
 *
 * If so, return the integer. If not, return -1.
 *
 * If there are multiple solutions, return any one.
 *
 * Example :
 *
 * Input : [1 2 3 1 1]
 * Output : 1
 * 1 occurs 3 times which is more than 5/3 times.
 */
public class NByThreeRepeatedElements {

    public static int getMajorithElement(List<Integer> elements){
        int count1 = 0, count2 = 0;
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < elements.size(); ++i){
            if (elements.get(i) == first){
                ++count1;
            }
            else if (elements.get(i) == second){
                ++count2;
            }
            else if (count1 == 0){
                first = elements.get(i);
                count1 = 1;
            }
            else if (count2 == 0){
                second = elements.get(i);
                count2 = 1;
            }
            else {
                --count1;
                --count2;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < elements.size(); ++i){
            if (elements.get(i) == first)
                ++count1;

            else if (elements.get(i) == second)
                ++count2;

        }

        if (count1 > elements.size()/2) return first;
        if (count2 > elements.size()/2) return second;
        return -1;
    }
}
