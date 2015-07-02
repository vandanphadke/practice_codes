import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ShortestPathAlgos {
	
	public static void Dijksrtas(GraphAdjListUndirected graph, int source){
		HashSet<Integer> settled = new HashSet<Integer>();
		HashSet<Integer> unsettled = new HashSet<Integer>();
		int[] distance = new int[graph.getNoofVertices()];
		int[] parent = new int[graph.getNoofVertices()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0 ;
		//settled.add(source);
		for(int i = 0 ; i < graph.getNoofVertices() ; i++)
			unsettled.add(i);
		
		while(!unsettled.isEmpty()){
			//get the source having the smallest distance
			System.out.println(settled);
			System.out.println(unsettled);
			int min = Integer.MAX_VALUE; 
			int selected_vertex = Integer.MAX_VALUE; 
			for(int i: unsettled){
				int d = distance[i];
				if(d < min){
					min = d ;
					selected_vertex = i ; 
				}
			}
			System.out.println(selected_vertex);
			
			ArrayList<Edge> select = graph.getEdges(selected_vertex);
			for(Edge e: select){
				int old_distance = distance[e.getDestination()];
				int new_distance = distance[selected_vertex] + e.getWeight();
				if(new_distance < old_distance){
					distance[e.getDestination()] = new_distance;
					parent[e.getDestination()] = selected_vertex;	
				}	
			}
			unsettled.remove(selected_vertex);
			settled.add(selected_vertex);
		}
		System.out.println(Arrays.toString(distance));
		System.out.println(Arrays.toString(parent));
	}
}
