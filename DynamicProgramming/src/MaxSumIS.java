public class MaxSumIS {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 101, 2, 3, 100, 4, 5};
		System.out.println(msis(arr));
	}
	
	private static int msis(int[] arr){
		int[] ms = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++)
			ms[i] = arr[i];
		
		for(int i = 1 ; i < arr.length ; i++){
			for(int j = 0 ; j < i ; j++){
				if(arr[i] > arr[j] && ms[i] < ms[j] + arr[i])
					ms[i] = ms[j] + arr[i];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < ms.length ; i++)
			if(ms[i] > max)
				max = ms[i];
		
		return max ;
	}
}