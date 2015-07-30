import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Q: Input Format
The first line contains two integers, N and I, separated by a single space. 
I lines follow. Each line contains 2 integers separated by a single space A and B 
such that

0 ≤ A, B ≤ N-1

and A and B are astronauts from the same country.

Output Format
An integer that denotes the number of permissible ways to choose a pair of astronauts.
 * @author Vandan Phadke
 *
 */
public class JourneyToTheMoon {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception{
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = bfr.readLine().split(" ");
        int vertices = Integer.parseInt(temp[0]);
        int edges = Integer.parseInt(temp[1]);
        ArrayList[] adj_list = new ArrayList[vertices];
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0 ; i < adj_list.length ; i++)
        	adj_list[i] = new ArrayList();
        int[] nums = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(nums, -1);
        for(int i = 0; i < edges; i++){
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            adj_list[a].add(b);
            adj_list[b].add(a);
        }

        int no = 0 ; 
        for(int i = 0 ; i < vertices ; i++){
        	if(!visited[i]){
        		visited[i]  = true;
                q.add(i);
                nums[i] = no++ ;
                while(!q.isEmpty()){
                	int v = q.poll();
                	for(int j = 0 ; j < adj_list[v].size() ; j++){
                		int e = (int)adj_list[v].get(j);
                		if(!visited[e]){
                			nums[e] = nums[v];
                			visited[e] = true;
                			q.add(e);
                		}
                	}
                }
        	}
        }

        System.out.println(no);
        int[] freq = new int[no];
        for(int i = 0 ; i < nums.length ; i++){
        	++freq[nums[i]];
        }
        long comb = getComb(vertices, 2);
        System.out.println(comb);
        for(int i = 0 ; i < freq.length ; ++i)
        	comb = comb - getComb(freq[i], 2);
        System.out.println(Arrays.toString(freq));
        System.out.println(comb);
        

    }
	
	public static long getComb(int n, int r){
		long comb = getFact(n)/(getFact(n-r)*getFact(r));
		return comb;
	}

	public static long getFact(int n){
        long f=1;

        for(int i=n;i>=1;i--){
        	f*=i;
        }
        
        if(f == 0)
        	return 1 ; 
        
        return f;
    }
}
