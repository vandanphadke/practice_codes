public class ActivitySelection {
	public static void main(String[] args) {
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] finish = {2, 4, 6, 7, 9, 9};
		
		int i = 0 ; 
		System.out.print(i);
		
		for(int j = 1 ; j < start.length ; j++){
			if(start[j] >= finish[i]){
				System.out.print(j);
				i = j ; 
			}		
		}
		
	}
}
