import java.util.ArrayList;
import java.util.Arrays;


public class LongestPathDag {
	/**
	 * Get the longest path from one vertice to all others in a directed acyclic graph
	 * @return
	 */
	public static int[] getLongestPathDAG(GraphAdjMatDirected graph, int source){
		int[] distance = new int[graph.getNoofVertices()];
		ArrayList<Integer> topological_sort_order = graph.topologicalSort();
		Arrays.fill(distance, Integer.MIN_VALUE);
		distance[source] = 0 ;
		int[][] adjMat = graph.getMatrix();
		for(int i = 0 ; i < topological_sort_order.size() ; i++){
			int vertex = topological_sort_order.get(i);
			System.out.println("Vertex is" + vertex + "distance is" + distance[vertex]);
			if(distance[vertex] != Integer.MIN_VALUE){
				for(int j = 0 ; j < adjMat[vertex].length ; j++){
					if(adjMat[vertex][j] != 0 && distance[j] < distance[vertex] + adjMat[vertex][j])
						distance[j] = distance[vertex] + adjMat[vertex][j];
				}
				System.out.println(Arrays.toString(distance));
			}
		}
		return distance ; 
	}
}
