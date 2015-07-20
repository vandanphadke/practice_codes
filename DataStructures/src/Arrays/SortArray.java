package Arrays;

import java.util.Arrays;

/**
 * Q: Given an almost sorted array where only two elements are swapped, 
 *    how to sort the array efficiently?
 * @author Vandan Phadke
 *  
 */
public class SortArray {
	public static void main(String[] args) {
		int[] arr = new int[]{10, 20, 60, 40, 50, 30};
		int n = arr.length;
		int i = 0, j = n - 1 ;
		while(i < j){
			while(arr[i+1] > arr[i])
				++i;
			while(arr[j-1] < arr[j])
				--j;
			break; 
		}
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		System.out.println(Arrays.toString(arr));
	}
}
