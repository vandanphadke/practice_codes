/**
 * Write a function which takes an array and prints the majority element (if it exists),
 * otherwise prints “No Majority Element”.
 *
 * A majority element in an array A[] of size n is an element that appears more than n/2 times
 * (and hence there is at most one such element).
 *
 */
public class MajorityElement {

    public static void main(String[] args){
        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println(getMajorityElement(arr));
    }

    private static int getMajorityElement(int[] arr) {
        int candidate = arr[0];
        int count = 1;
        for (int i = 0 ; i < arr.length; ++i){
            if (arr[i] != candidate)
                --count;
            else
                ++count;

            if (count == 0){
                candidate = arr[i];
                count = 1;
            }
        }

        int actual = 0;
        for (int i = 0 ; i < arr.length; ++i)
            if (arr[i] == candidate)
                ++actual;

        if (actual > (arr.length / 2)){
            return candidate;
        }
        else
            return -1;

    }

}
