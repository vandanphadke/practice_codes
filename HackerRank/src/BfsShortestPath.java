import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class BfsShortestPath {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        while(T-- != 0){
            String[] line = in.readLine().split(" ");
            int vertices = Integer.parseInt(line[0]);
            long edges = Long.parseLong(line[1]);
            ArrayList[] adj_list = new ArrayList[vertices];
            int[] distance = new int[vertices];
            boolean[] visited = new boolean[vertices];
            Arrays.fill(distance, Integer.MAX_VALUE);
            Queue<Integer> q = new LinkedList<Integer>();
            for(int i = 0 ; i < vertices ; ++i){
                adj_list[i] = new ArrayList(); 
            }
            while(edges-- != 0){
                String[] edge = in.readLine().split(" ");
                int src = Integer.parseInt(edge[0]);
                int dest = Integer.parseInt(edge[1]);
                adj_list[src - 1].add(dest - 1);
                adj_list[dest - 1].add(src - 1);
            }
            int start = Integer.parseInt(in.readLine()) - 1;
            /*for(int i = 0 ; i < adj_list.length ; i++)
            	System.out.println(adj_list[i]);*/
            
            //System.out.println("Start" + start);
            distance[start] = 0 ;
            q.add(start);
            visited[start] = true; 
            while(!q.isEmpty()){
                int vertex = q.poll();
                //System.out.println("Vertex " + vertex + Arrays.toString(distance));
                ArrayList adj = adj_list[vertex] ; 
                for(int i = 0 ; i < adj.size() ; i++){
                    if(!visited[(int) adj.get(i)]){ 
                        int dest = (int)adj.get(i);
                        visited[dest]  = true;
                        if(distance[dest] > distance[vertex] + 6)
                            distance[dest] = distance[vertex] + 6 ;
                        q.add(dest);
                    } 
                }
            }
            for(int i = 0 ; i < distance.length ; i++){
                if(distance[i] == 0)
                    continue;
                else if(distance[i] == Integer.MAX_VALUE)
                    System.out.print("-1 ");
                else
                    System.out.print(distance[i] + " ");
            }
        }
    }
}
