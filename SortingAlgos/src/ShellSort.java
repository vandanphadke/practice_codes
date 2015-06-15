import java.util.Arrays;


public class ShellSort {
	public static void main(String[] args) {
		int[] n = new int[]{7,3,4,5,1,2,59,0 };
		n = shellSort(n);
		System.out.println(Arrays.toString(n));
	}
	
	/***
	 * Sorts the integer array using Shell Sort using Shell's sequence
	 * @param data input int array
	 * @return data sorted array
	 */
	public static int[] shellSort(int[] data){
		int gap = 1 ; 
		for(; gap < data.length ; gap= gap*2 + 1);
		
		while(gap > 0){
			for(int i = gap ; i < data.length ; i++){
				int temp = data[i];
				int j = i ;
				while (j >= gap && data[j - gap] > temp) 
                {
					data[j] = data[j - gap];
                    j = j - gap;
                }
				data[j] = temp;
			}
			gap = gap/2;
		}
		return data; 
	}
}
