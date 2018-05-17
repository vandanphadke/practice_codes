package Basic;

public class MatrixMultiply {
	public static void main(String[] args) {
		
	}
	
	public static void optimalmatrixMultiply(int[] mat){
		int[][] data = new int[mat.length][mat.length];
		for(int i = 0 ; i < data.length ; i++)
			data[i][i] = 0 ;
		int j , q; 
		for(int l = 2 ; l < data.length ; l++){
			for(int i = 1 ; i <= data.length - l + 1 ; i++){
				j = i + l - 1 ;
				data[i][j] = Integer.MAX_VALUE;
				for(int k = i ; k <= j - 1 ; k++){
					q = data[i][k] + data[k+1][j] + mat[i-1]*mat[k]*mat[j];
					if(q < data[i][j])
							data[i][j] = q ; 
				}
			}
		}
		System.out.println(data[1][mat.length - 1]);
	}
}
