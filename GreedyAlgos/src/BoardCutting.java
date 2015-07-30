import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Q: https://www.hackerrank.com/challenges/board-cutting
 * @author Vandan Phadke
 */
public class BoardCutting {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		String[] line;
		while(T-- != 0){
			line = in.readLine().split(" ");
			int m = Integer.parseInt(line[0]);
			int n = Integer.parseInt(line[1]);
			long[] a = new long[m-1];
			long[] b = new long[n-1];
			long xSegs = 1, ySegs = 1 ; 
			line = in.readLine().split(" ");
			for(int i = 0 ; i < m - 1 ; i++) a[i] = Integer.parseInt(line[i]);
			line = in.readLine().split(" ");
			for(int i = 0 ; i < n - 1 ; i++) b[i] = Integer.parseInt(line[i]);
			Arrays.sort(a);
			Arrays.sort(b);
			int i = m - 2, j = n - 2 ;
			long cost = 0; 
			while(i >= 0 && j >= 0){
				if(a[i] > b[j]){
					cost += (a[i] * (ySegs)) % (1000000007);
					xSegs++;
					--i;
					//System.out.println("1 " + cost);
				}
				else if(a[i] < b[j]){
					cost += b[j] * (xSegs) % (1000000007);
					ySegs++;
					--j;
					//System.out.println("2 " + cost);
				}
				else if(m > n){
					cost += a[i] * (ySegs) % (1000000007);
					xSegs++;
					--i;
					//System.out.println("3 " + cost);
				}
				else{
					cost += b[j] * (xSegs) % (1000000007);
					ySegs++;
					--j;
					//System.out.println("4 " + cost);
				}
			}
			if(i >= 0){
				while(i >= 0){
					cost += a[i] * (ySegs) % (1000000007);
					xSegs++;
					--i;
					//System.out.println("5 " + cost);
				}
			}
			if(j >= 0){
				while(j >= 0){
					cost += b[j] * (xSegs) % (1000000007);
					ySegs++;
					--j;
					//System.out.println("6 " + cost);
				}
			}
			System.out.println(cost % (1000000007));
		}
	}
}