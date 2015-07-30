package linkedin;

/**
 * Q: You are given a 2-D matrix with M rows and N columns.
 * You are initially positioned at (0,0) which is the top-left cell in the array. 
 * You are allowed to move either right or downwards. The array is filled with 1’s and 0’s.
 * A 1 indicates that you can move through that cell, a 0 indicates that you cannot move 
 * through that cell. Return the number of paths from top-left cell to bottom-right cell.
 * (i.e. (0,0)to(M-1,N-1)). Since answer can be large thus you have to return ans%(10^9+7).
 * Constraints: Best time and space complexity were required to cover all the test cases for both questions.
 * @author Vandan Phadke
 *
 */
public class NoOFPaths {
	public static void main(String[] args) {
		int[][] paths = {{1,0,1,1,1,1},
						 {1,1,1,0,1,0},
						 {1,0,1,0,1,0},
						 {1,1,1,1,1,1}};
		System.out.println(getNoofPaths(paths, paths.length, paths[0].length));
	}
	
	public static int getNoofPaths(int[][] path, int m, int n){
		int[][] mat = new int[m][n];
		boolean flag = false;
		for(int i = 0 ; i < n ; i++){
			if(path[0][i] == 0){
				mat[0][i] = 0 ;
				flag = true;
			}
			else if(flag == true){
				mat[0][i] = 0; 
			}
			else{
				mat[0][i] = 1; 
			} 
		}
		
		flag = false;
		for(int i = 1 ; i < m ; i++){
			if(path[i][0] == 0){
				mat[i][0] = 0 ;
				flag = true;
			}
			else if(flag == true)
				mat[i][0] = 0; 
			else
				mat[i][0] = 1; 
		}
		
		for(int i = 1 ; i < m ; i++){
			for(int j = 1 ; j < n ; j++){
				if(path[i][j] != 0)
					mat[i][j] = mat[i-1][j] + mat[i][j-1];
			}
		}
		return mat[m-1][n-1];
	}
}
