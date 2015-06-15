
public class CountingSort {
	public static void main(String[] args) {
		int[] inp = new int[]{0,2,1,1,3,4,4,3,2,1,2};
		int[] out = countingSort(inp);
		for(int i: out)
			System.out.print(i + "\t");
		System.out.println();
	}
	
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
	
	public static int[] bucketSort(int[] data){
		
		return data;
	}
}
