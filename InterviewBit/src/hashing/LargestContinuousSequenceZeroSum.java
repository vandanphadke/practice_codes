package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 Find the largest continuous sequence in a array which sums to zero.

 Example:


 Input:  {1 ,2 ,-2 ,4 ,-4}
 Output: {2 ,-2 ,4 ,-4}

 NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 */

public class LargestContinuousSequenceZeroSum {

    public static void main(String[] args){
        List<Integer> num = new ArrayList<>();
        num.add(1);num.add(2);num.add(-3);num.add(3);//num.add(6);num.add(-8);
        System.out.println(getlargest(num));
    }

    public static List<Integer> getlargest(List<Integer> arr){
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> sums = new HashMap<>();

        int cumSum = 0;
        int maxlength = Integer.MIN_VALUE, maxi = 0, maxj = 0;

        for (int i = 0; i < arr.size(); ++i){
            cumSum += arr.get(i);

            if (cumSum == 0){
                if (maxlength < (i+1)){
                    maxlength = i + 1;
                    maxi = 0;
                    maxj = i;
                }
            }
            else {
                if (sums.containsKey(cumSum)){
                    int currLength = i - sums.get(cumSum) - 1;
                    if (currLength > maxlength){
                        maxlength = currLength;
                        maxi = sums.get(cumSum) + 1;
                        maxj = i;
                    }
                }
                else {
                    sums.put(cumSum, i);
                }
            }
        }

        if(maxlength == Integer.MIN_VALUE) return new ArrayList<>();
        for (int i = maxi; i <= maxj; ++i) result.add(arr.get(i));
        return result;
    }
}
