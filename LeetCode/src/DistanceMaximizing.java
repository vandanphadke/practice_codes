import java.util.ArrayList;

/**
 * 
 * @author Vandan Phadke
 * Q: Given an array A of integers, 
 *    find the maximum of j-i subjected to the constraint of A[i] < A[j].
 */
public class DistanceMaximizing {
	public static void main(String[] args) {
		int[] arr = new int[]{4,3,5,2,1,3,2,3};
		System.out.println(getMaxDistance(arr));
	}
	
	public static int getMaxDistance(int[] arr){
		ArrayList<Integer> mins = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < arr.length ; i++){
			if(arr[i] < min){
				min = arr[i] ; 
				mins.add(i);
			}
		}

		ArrayList<Integer> dist = new ArrayList<Integer>();
		for(int i = arr.length - 1 ; i >= 0 ; i--){
			for(int j: mins){
				if(arr[i] > arr[j]){
					dist.add(i-j);
					break; 
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int d: dist){
			if(d > max)
				max = d ; 
		}
		return max;
	}
}
