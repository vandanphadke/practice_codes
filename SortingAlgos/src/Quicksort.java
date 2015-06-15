import java.util.Arrays;

public class Quicksort{
	
	static int no_of_swaps = 0 ; 
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,9,8,2,7,5};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		
		System.out.println(no_of_swaps);
	}
	
	public static void quickSort(int[] arr, int low, int high)
	{
		int pivot ; 
		
		if(high > low){
			pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}	
	}

	private static int partition(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		//move high to low element
		int temp1  = arr[high];
		arr[high] = arr[low];
		arr[low]= temp1 ;
		
		int left = low, right = high, pivot_item = arr[low];
		
		while(left < right)
		{
			while(arr[left] <= pivot_item)
				left++; 
			while(arr[right] > pivot_item)
				right--;
			
			if(left < right){
				//exchange left and right
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp ;
				no_of_swaps++;
				//System.out.println(no_of_swaps);
			}
		}
		
		arr[low] = arr[right];
		arr[right] = pivot_item;
		no_of_swaps++;
		return right;
	}
}