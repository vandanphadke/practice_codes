
public class RotateMatrixInPlace {
			
	public static void main(String[] args) {
		int[][] mat = new int[4][4];
		for(int i = 0 ; i < 4 ; i++)
			for(int j = 0 ; j < 4 ; j++)
				mat[i][j] = 4*i + j ;
		rotate90Degree(mat);
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
		for(int i = 0 ; i < mat.length ; i++){
			for(int j = 0 ; j < mat.length ; j++)
				System.out.print(mat[i][j] + "\t");
			System.out.println();
		}
	}
}
