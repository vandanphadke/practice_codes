
public class MagicSquare {
	public static void main(String[] args) {
		printMagicSquare(7);
	}
	
	public static void printMagicSquare(int n){
		int[][] arr = new int[n][n];
		int i = n/2; 
		int j = n - 1 ;
		
		for(int num = 1 ; num <= n*n ; ){
			if(i == -1 && j == n){
				j = n - 2 ; 
				i = 0 ; 
			}
			else{
				if(j == n)
					j = 0 ; 
				if(i < 0)
					i = n - 1 ;
			}
			
			if(arr[i][j] != 0){
				j = j - 2 ;
				i++; 
				continue;
			}
			else{
				arr[i][j] = num++; 
			}
			++j;--i; 
		}
		for(int a = 0 ; a < n ; a++){
			for(int b = 0 ; b < n ; b++)
				System.out.print(arr[a][b] + "\t");
			System.out.println();
		}
	}
	
}
