package Basic;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMultiply {
	public static void main(String[] args) {
		int[] cost = new int[]{30, 35, 15, 5, 10, 20, 25};
		System.out.println(optimalmatrixMultiply(cost));
	}
	
	public static int optimalmatrixMultiply(int[] mat){
		int n = mat.length - 1;
		int[][] data = new int[n + 1][n + 1];

		// Cost of multiplying a matrix to itself is 0
		for(int i = 1 ; i < n+1 ; i++)
			data[i][i] = 0 ;

		int j , q;

		for(int l = 2 ; l <= n ; l++) {
			for(int i = 1 ; i <= n - l + 1 ; i++){
				j = i + l - 1 ;
				data[i][j] = Integer.MAX_VALUE;
				System.out.println("Current i: " + i + " Current j: " + j);
				for(int k = i ; k < j ; k++){
					q = data[i][k] + data[k+1][j] + mat[i-1]*mat[k]*mat[j];
					if(q < data[i][j])
							data[i][j] = q ; 
				}
			}
		}


		for (int i = 0; i < data.length; i++) {
			System.out.println(Arrays.toString(data[i]));
		}

		return data[1][n];
	}
}
