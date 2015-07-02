import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EditDistance {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String a = in.readLine().trim().toLowerCase();
		String b = in.readLine().trim().toLowerCase();
		System.out.println(editdistance(a,b));
	}
	
	public static int editdistance(String a, String b){
		int l1 = a.length();
		int l2 = b.length();
		int[][] data = new int[l1 + 1][l2+1];
		
		for(int i = 1 ; i <= l1 ; i++){
			for(int j = 1 ; j <= l2 ; j++){
				int c = Math.min( data[i-1][j] + 1, data[i][j-1] + 1);
				int cost = 0 ; 
				if(a.charAt(i-1) == b.charAt(j-1))
					cost = 0 ;
				else
					cost = 1 ; 
				
				data[i][j] = Math.min(c, data[i-1][j-1] + cost);
			}
		}
		return data[l1][l2];
	}
}
