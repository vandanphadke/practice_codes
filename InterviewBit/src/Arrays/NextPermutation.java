package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Implement the next permutation, which rearranges numbers into the
 * numerically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must be rearranged as the
 * lowest possible order ie, sorted in an ascending order.
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Examples:
 *
 * 1,2,3 → 1,3,2
 *
 * 3,2,1 → 1,2,3
 *
 * 1,1,5 → 1,5,1
 *
 * 20, 50, 113 → 20, 113, 50
 * Inputs are in the left-hand column and its corresponding outputs
 * are in the right-hand column.
 *
 */
public class NextPermutation {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);arr.add(3);arr.add(4);arr.add(9);
        arr.add(7);arr.add(6);
        getNextPermutation(arr);
        System.out.println(arr);
    }


    public static void getNextPermutation(ArrayList<Integer> arr){
        int n = arr.size();
        int less = -1;

        for (int i = n - 1; i > 0 ; --i){
            if (arr.get(i) > arr.get(i - 1)){
                less = i;
            }
        }

        if (less == -1){
            reverse(arr, 0, n - 1);
            return;
        }

        --less;

        int minIndex = 0;

        for (int i = less + 1; i < n; ++i){
            if (arr.get(i) > arr.get(less)){
                minIndex = i;
            }
        }

        swap(arr, less, minIndex);
        reverse(arr, less + 1, n - 1);
    }

    public static void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static void reverse(ArrayList<Integer> arr, int l, int r){
        int i = l, j = r;
        while (i < j){
            swap(arr, i, j);
            ++i;
            --j;
        }
    }
}
