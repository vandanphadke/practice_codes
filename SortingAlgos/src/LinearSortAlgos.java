import java.util.ArrayList;
import java.util.Arrays;


public class LinearSortAlgos {
	public static void main(String[] args) {
		int[] inp = new int[]{33,12,45,21,55,98,64,31};
		int[] out = radixSort(inp,2);
		System.out.println(Arrays.toString(out));
	}
	
	/**
	 * 
	 * @param arr
	 * @return Sorted array using counting sort
	 */
	public static int[] countingSort(int[] arr){
		
		int[] temp = new int[arr.length];
		int[] sorted_arr = new int[arr.length];
		
		for(int i: arr)
			++temp[i];
		
		for(int i = 1 ; i < temp.length ; i++)
			temp[i] += temp[i-1];
			
		int j = 0;
        for (int i = 0; i < temp.length - 1; i++)
            while (j < temp[i])
                sorted_arr[j++] = i;
        
		return sorted_arr;
	}

	/***
	 * Sorts input array using bucket sort
	 * (Assume array between 0 to 10)
	 * @param data input array
	 * @return sorted array
	 */
	public static int[] bucketsort(int[] a, int maxVal) {
	      int [] bucket=new int[maxVal+1];
	 
	      for (int i=0; i<bucket.length; i++) {
	         bucket[i]=0;
	      }
	 
	      for (int i=0; i<a.length; i++) {
	         bucket[a[i]]++;
	      }
	 
	      int outPos=0;
	      for (int i=0; i<bucket.length; i++) {
	         for (int j=0; j<bucket[i]; j++) {
	            a[outPos++]=i;
	         }
	      }
	      return a; 
	   }
	
	/**
	 * 
	 * @param a
	 * @return Sorted array using radix sort
	 */
	public static int[] radixSort(int[] a, int maxDigits){
		int exponent = 1 ; 
		
		for(int i = 0 ; i < maxDigits ; i++){
			ArrayList[] bucketList = new ArrayList[10];
			for(int k = 0 ; k < 10; k++)
				bucketList[k] = new ArrayList();
			
			for(int j = 0 ; j < a.length ; j++){
				int number = (a[j]/exponent)%10;
				bucketList[number].add(a[j]);
			}
			
			exponent = exponent*10;
			int index = 0 ; 
			
			for(int k = 0 ; k < 10 ; k++){
				ArrayList arr = bucketList[k];
				for(int j = 0 ; j < arr.size() ; j++){
					a[index] = (int)arr.get(j);
					index++;
				}
			}
			
		}
		
		
		
		
		return a; 
	}
}
