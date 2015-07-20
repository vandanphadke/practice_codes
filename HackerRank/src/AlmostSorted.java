import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class AlmostSorted {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int flag = 0 ; 
		int n = Integer.parseInt(in.readLine());
		int[] inp = new int[n];
		int[] inp2 = new int[n];
		String[] line = in.readLine().split(" ");
		
		for(int i = 0 ; i < n ; i++){
			inp[i] = Integer.parseInt(line[i]);
			inp2[i] = Integer.parseInt(line[i]);  
		}
		
		Arrays.sort(inp2);
		
		if(Arrays.equals(inp, inp2)){
			System.out.println("yes");
			flag = 1 ; 
			return;
		}
		
		else{
			for(int j = 0 ; j < n ; j++)
			{
				for(int k = 0 ; k < n ; k++)
				{
					//swap j and k in ip1
					int temp = inp[j];
					inp[j] = inp[k];
					inp[k] = temp;
					
					if(Arrays.equals(inp, inp2)){
						System.out.println("yes");
						System.out.println("swap " + (j+1) + " " + (k+1));
						flag = 1 ; 
						return; 
					}
					
					else{
						//swap back
						int temp1 = inp[j];
						inp[j] = inp[k];
						inp[k] = temp1;
					}
				}
			}
			
			//Push array to a stack
			Stack<Integer> st = new Stack<Integer>();
			for (int i = 0; i < n; i++) {
				st.push(inp[i]);
			}
			
			int i = n-1 ; 
			for( ; i >= 1 ; i--)
			{
				if(inp[i] >= inp[i-1])
					continue;
				else
					break;
			}
			
			//System.out.println(i);
			int ans1 = i ; 
			
			int j = i ; 
			for(; j >= 1 ; j--){
				if(inp[j-1] >= inp[j])
					continue;
				else
					break;
			}
			
			//System.out.println(j);
			int ans2 = j ; 
			
			//Reverse the array from i to j
			int[] inp3 = new int[n];
			
		int k = 0 ; 
		while(k < j){
			inp3[k] = inp[k];
			k++;
		}
		
		int z = i ; 
		
		while(k <= i)
		{
			inp3[k] = inp[z];
			k++;
			z--;
		}
		
		while(k < n){
			inp3[k] = inp[k];
			k++;
		}
		
		//System.out.println(Arrays.toString(inp3));
		
		if(Arrays.equals(inp2, inp3)){
			System.out.println("yes");
			System.out.println("reverse " + (ans2+1) + " " + (ans1+1));
			flag = 1 ;
			return; 
		}

		}
		
		if(flag == 0)
			System.out.println("no");
	}
}
