
public class GetSingleElement {
	public static void main(String[] args) {
		int[] arr = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
		System.out.println(arr);
	}
	
	public static int getSingle(int[] arr){
		int size = Integer.SIZE;
		int x = 0, sum = 0, result = 0;
		
		for(int i = 0;  i < size ; i++){
			x = (1 << i);
			sum = 0 ;
			
			for(int j = 0 ; j < arr.length ; j++){
				if((arr[j] & x) == 1)
					sum++;
			}
			
			if(sum % 3 == 0)
				result |= x ; 
		}
		return new Integer(result) ; 
	}
}
