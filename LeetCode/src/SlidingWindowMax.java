import java.util.ArrayList;


public class SlidingWindowMax {
	public static void main(String[] args) {
		int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
		ArrayList<Integer> maxs = new ArrayList<Integer>();
		int w = 3 ;
		int i = 0 ;
		int max = 0;
		while(i < w){
			if(arr[i] > arr[max]){
				max = i ; 
			}
			i++;
		}
		maxs.add(max);
		int j = max; 
		while( i < arr.length){
			
		}
		
	}
}
