package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedLists {

    public static ArrayList<Integer> getIntersection(List<Integer> arr1, List<Integer> arr2){
        ArrayList<Integer> results = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.size() && j < arr2.size()){
            if (arr1.get(i) == arr2.get(j)){
                results.add(arr1.get(i));
                ++i;
                ++j;
            }
            else if (arr1.get(i) < arr2.get(j)){
                ++i;
            }
            else
                ++j;
        }
        return results;
    }

}
