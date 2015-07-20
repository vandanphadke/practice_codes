
public class MaximalSquare {
	public static void main(String[] args) {
		int[][] M =  {{0, 1, 1, 0, 1}, 
                	  {1, 1, 1, 1, 1}, 
                	  {1, 1, 1, 1, 1},
                	  {1, 1, 1, 1, 1},
                	  {1, 1, 1, 1, 1},
                	  {0, 0, 0, 0, 0}};
		
		System.out.println(maximalSquare(M));
	}
	
	public static int maximalSquare(int[][] arr){
		int[][] grid = new int[arr.length][arr[0].length];
		
		for(int i = 0 ; i < arr.length ; i++)
			grid[i][0] = arr[i][0];
		
		for(int i = 0 ; i < arr[0].length ; i++)
			grid[0][i] = arr[0][i];
		
		for(int i = 1 ; i < arr.length ; i++){
			for(int j = 1 ; j < arr[0].length ; j++){
				if(arr[i][j] == 1){
					int temp = Math.min(grid[i-1][j], grid[i][j-1]);
					grid[i][j] = Math.min(grid[i-1][j-1], temp) + 1;
				}
				else
					grid[i][j] = 0 ; 
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < grid.length ; i++){
			for(int j = 0 ; j < arr[0].length ; j++){
				if(grid[i][j] > max)
					max = grid[i][j];
			}
		}
		
		return max*max;
	}
}
