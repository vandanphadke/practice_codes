import java.util.Arrays;

/**
 * Question: Given an unsorted array of both negative and positive integer.
 * The task is place all negative element at the end of array without changing t
 * he order of positive element and negative element.
 * Input : arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
 * Output : { 1  3  2  11  6  -1  -7  -5 }
 * */

public class MoveNegElements {
    public static void main(String[] args){
        int[] testArr = new int[]{1, -1, 3, 2, -7, -5, 11, 6 };
        processArray(testArr, testArr.length);
        System.out.println(Arrays.toString(testArr));
    }

    public static void processArray(int[] arr, int n){
        int key, j;
        for(int i = 1; i < n; i++)
        {
            key = arr[i];

            if (key > 0)
                continue;

            j = i - 1;
            while (j >= 0 && arr[j] > 0)
            {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }
}
