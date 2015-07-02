import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MinCostMatrix {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[][] path = new int[n][n];
		int[][] cost = new int[n + 1][n + 1];	
		char[][] dir = new char[n + 1][n + 1];
		for(int i = 0 ; i < n ; i++){
			String[] line = in.readLine().split(" ");
			for(int j = 0 ; j < n ; j++)
				path[i][j] = Integer.parseInt(line[j]);
		}
		
		for(int i = 1 ; i <= n ; i++){
			for(int j = 1 ; j <= n ; j++){
				cost[i][j] = findMin(cost[i-1][j], cost[i][j-1], cost[i][j-1]) + path[i-1][j-1];
			}
		}
		
		for(int i = 1 ; i <= n ; i++ ){
			for(int j = 1 ; j <= n ; j++)
				System.out.print(cost[i][j] + "\t");
			System.out.println();
		}		
		
	}

	private static int findMin(int x, int y, int z) {
		if(x < y)
			return (x < z ? x : z);
		else
			return (y < z ? y : z);
	}
}	
