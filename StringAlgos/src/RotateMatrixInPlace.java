
public class RotateMatrixInPlace {
			
	public static void main(String[] args) {
		int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		/*for(int i = 0 ; i < 4 ; i++)
			for(int j = 0 ; j < 4 ; j++)
				mat[i][j] = 4*i + j ;*/
		//rotate90Degree(mat);
		rotate(mat);
		for(int i = 0 ; i < mat.length ; i++){
			for(int j = 0 ; j < mat.length ; j++)
				System.out.print(mat[i][j] + "\t");
			System.out.println();
		}
	}

	private static void rotate90Degree(int[][] mat) {
		int layers = mat.length / 2 ; 
		for(int i = 0 ; i < layers ; i++){
			int first = i;
			int last = mat.length - 1 - i;
			for(int j = first ; j < last ; ++j){
				int offset = j = first; 
				int top = mat[first][j];
				
				mat[first][j] = mat[last - offset][first];
				mat[last - offset][first] = mat[last][last - offset];
				mat[last][last - offset] = mat[j][last];
				mat[j][last] = top ;
			}
		}
		/*for(int i = 0 ; i < mat.length ; i++){
			for(int j = 0 ; j < mat.length ; j++)
				System.out.print(mat[i][j] + "\t");
			System.out.println();
		}*/
	}
	
	public static void rotate(int[][] matrix) {
	    int n = matrix.length;
	    for(int y=0;y<n/2;y++){
	        for(int x=y;x < n-y-1;x++){
	            int temp=matrix[y][x];
	            temp=move(matrix,temp,(n-1)-y,x);
	            temp=move(matrix,temp,(n-1)-x,(n-1)-y);
	            temp=move(matrix,temp,y,(n-1)-x);
	            temp=move(matrix,temp,x,y);
	        }
	    }
	}
	public static int move(int[][]matrix,int val, int x, int y){
	    int store = matrix[y][x];
	    matrix[y][x]=val;
	    return store;
	}
}
