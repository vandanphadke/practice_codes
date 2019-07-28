package greedy;

import java.util.List;

/**
 * Given an array of size n, find the majority element. The majority element
 * is the element that appears more than floor(n/2) times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * Example :
 *
 * Input : [2, 1, 2]
 * Return  : 2 which occurs 2 times which is greater than 3/2.
 */
public class MajorityElement {
    public int getMajorityElement(List<Integer> arr){
        int current = arr.get(0);
        int count = 1;
        for (int i = 1; i < arr.size(); ++i){
            if (arr.get(i) == current){
                ++count;
            }
            else {
                if (count == 1){
                    current = arr.get(i);
                }
                else {
                    --count;
                }
            }
        }
        int freq = 0;
        for (int i = 0; i < arr.size(); ++i){
            if (arr.get(i) == current){
                ++freq;
            }
        }
        if (freq > (arr.size() / 2)){
            return current;
        }
        return -1;
    }
}
