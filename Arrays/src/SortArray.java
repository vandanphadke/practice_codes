import java.util.Arrays;

/**
 * Q: Given an almost sorted array where only two elements are swapped, 
 *    how to sort the array efficiently?
 * @author Vandan Phadke
 *  
 */
public class SortArray {
	public static void main(String[] args) {
		int[] arr = new int[]{10, 20, 30, 50, 40, 60, 70, 80, 90};
		int n = arr.length;
		int i = 0, j = n - 1 ;
		while(i < j){
			while(i < n - 1 && arr[i+1] > arr[i])
				++i;
			while(j > 0 && arr[j-1] < arr[j])
				--j;
			break; 
		}
		if(i == n - 1 && j == 0)
			System.out.println("Array is sorted");
		else{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			System.out.println(Arrays.toString(arr));
		}
	}
}
