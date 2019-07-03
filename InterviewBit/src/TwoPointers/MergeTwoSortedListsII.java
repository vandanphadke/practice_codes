package TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note: You have to modify the array A to contain the merge of A and B.
 * Do not output anything in your code.
 *
 * TIP: C users, please malloc the result into a new array and return the result.
 * If the number of elements initialized in A and B are m and n respectively,
 * the resulting size of array A after your code is executed should be m + n
 *
 * Example :
 *
 * Input :
 *          A : [1 5 8]
 *          B : [6 9]
 *
 * Modified A : [1 5 6 8 9]
 *
 */
public class MergeTwoSortedListsII {

    public static void main(String[] args){
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);arr1.add(5);arr1.add(8);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(10);

        mergeLists(arr1, arr2);
        System.out.println(arr1);
    }


    public static void mergeLists(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        int m = arr1.size();
        int n = arr2.size();

        for (int i = 0; i < n; ++i){
            arr1.add(0);
        }

        int i = (m-1), j = (n-1), k = (m+n-1);
        while (i >= 0 && j >= 0){
            if (arr1.get(i) >= arr2.get(j)){
                arr1.set(k, arr1.get(i));
                --i;
            }
            else {
                arr1.set(k, arr2.get(j));
                --j;
            }
            --k;
        }

        if (i != -1){
            while (i >= 0){
                arr1.set(k, arr1.get(i));
                --i;
                --k;
            }
        }

        if (j != -1){
            while (j >= 0){
                arr1.set(k, arr2.get(j));
                --j;
                --k;
            }
        }
    }


}
