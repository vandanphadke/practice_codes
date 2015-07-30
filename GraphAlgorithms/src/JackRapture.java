import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Q: https://www.hackerrank.com/challenges/jack-goes-to-rapture
 * @author Vandan Phadke
 *
 */
public class JackRapture {
	public static void main(String[] args) throws IOException{
		System.out.println(Integer.MAX_VALUE);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
        int vertices = Integer.parseInt(temp[0]);
        int edges = Integer.parseInt(temp[1]);
        ArrayList<EdgeClass>[] adj_list = new ArrayList[vertices];
        for(int i = 0 ; i < adj_list.length ; i++)
        	adj_list[i] = new ArrayList<EdgeClass>();
        for(int i = 0; i < edges; i++){
            temp = in.readLine().split(" ");
            int src = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int weight = Integer.parseInt(temp[2]);
            adj_list[src - 1].add(new EdgeClass(dest - 1, weight));
            //System.out.println(src-1 + " " + dest + " " + weight);
        }
        boolean[] visited = new boolean[vertices];
        int[] cost = new int[vertices];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        cost[0] = 0 ;
        visited[0] = true; 
        while(!q.isEmpty()){
        	int v = q.poll();
        	for(int i = 0 ; i < adj_list[v].size() ; i++){
        		int v1 = (int)adj_list[v].get(i).dest;
        		int cost1 = adj_list[v].get(i).weight - cost[v];
        		if(cost1 < 0)
        			cost1 = 0 ;
        		
        		if(cost[v1] > cost1 + cost[v])
        			cost[v1] = cost1 + cost[v];
        		if(!visited[v1]){
        			visited[v1] = true;
        			q.add(v1);
        		}
        	}
        }
        
        if(cost[cost.length - 1] == Integer.MAX_VALUE)
        	System.out.println("NO PATH EXISTS");
        else
        	System.out.println(cost[cost.length - 1]);
    }
}

class EdgeClass{
	int dest, weight;
	public EdgeClass(int dest, int weight){
		this.dest = dest; 
		this.weight = weight;
	}
}
