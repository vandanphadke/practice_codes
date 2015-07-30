import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Q: You are given a tree (a simple connected graph with no cycles). 
 * You have to remove as many edges from the tree as possible to obtain a 
 * forest with the condition that : Each connected component of the forest 
 * should contain an even number of vertices.
 * https://www.hackerrank.com/challenges/even-tree
 * @author Vandan Phadke
 *
 */
public class EvenTree {
	static int ans = 0 ;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] line = in.readLine().split(" ");
		int vertices = Integer.parseInt(line[0]);
		int edges = Integer.parseInt(line[1]);
		ArrayList[] adj_list = new ArrayList[vertices];
		for(int i = 0 ; i < vertices ; i++){
			adj_list[i] = new ArrayList();
		}
		while(edges-- != 0){
			String[] edge = in.readLine().split(" ");
			int src = Integer.parseInt(edge[0]);
			int dest = Integer.parseInt(edge[1]);
			adj_list[src - 1].add(dest - 1);
			adj_list[dest - 1].add(src - 1);
		}
		boolean[] visited = new boolean[vertices];
		dfs(visited, 0, adj_list);
		System.out.println(ans);
	}
	
	@SuppressWarnings("unchecked")
	public static int dfs(boolean[] visited, int vertex, @SuppressWarnings("rawtypes") ArrayList[] adj_list){
		visited[vertex] = true;
		int num_vertex = 0 ; 
		ArrayList<Integer> adj = adj_list[vertex];
		for(int i = 0 ; i < adj.size() ; i++){
			if(!visited[adj.get(i)]){
				int num_nodes = dfs(visited, adj.get(i), adj_list);
				if(num_nodes % 2 == 0)
					++ans;
				else
					num_vertex += num_nodes;
			}		
		}
		return num_vertex + 1; 
	}
}
