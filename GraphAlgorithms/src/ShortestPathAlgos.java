import java.util.Arrays;

public class ShortestPathAlgos {
	
	/**
	 * Dijkstra's Algorithm
	 * @param graph 
	 * @param source
	 * @return distance matrix wrt source
	 */
	public static int[] dijkstrasAlgo(GraphAdjMatDirected graph, int source){
		int vertices = graph.getNoofVertices();
		int[][] adjMat = graph.getMatrix();
		int[] distance = new int[vertices];
		boolean[] isSet = new boolean[vertices];
		int[] parent = new int[vertices];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[source] = 0 ;
		parent[source] = -1 ;
		
		for(int i = 0 ; i < vertices ; i++){
			int u = minDistance(distance, isSet);
			isSet[u] = true;
			
			for(int v = 0 ; v < vertices ; v++){
				if(!isSet[v] && adjMat[i][v] != 0 && distance[i] != Integer.MAX_VALUE 
						&& distance[i] + adjMat[i][v] < distance[v]){
					distance[v] = distance[i] + adjMat[i][v];
					parent[v] = i ;
				}
			}
		}
		System.out.println(Arrays.toString(parent));
		return distance; 
	}
	
	//Find the minimum distance vertex from the set
	public static int minDistance(int[] distance, boolean[] isSet){
		int min = Integer.MAX_VALUE, min_index = 0;
		for(int v = 0 ; v < distance.length ; v++){
			if(!isSet[v] && distance[v] < min){
				min = distance[v];
				min_index = v ; 
			}
		}
		return min_index ; 
	}
	
	/**
	 * Returns the least distance matrix based on the Bellman Fords Algo
	 * @param graph Adjacent Matrix Directed
	 * @param source starting vertex
	 * @return distance matrix
	 */
	public static int[] bellmanFordAlgo(GraphAdjMatDirected graph, int source){
		int[][] adjMat = graph.getMatrix();
		int vertices = graph.getNoofVertices();
		int[] dist = new int[vertices];
		int[] parent = new int[vertices];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0 ;
		parent[source] = -1 ; 
		for(int v = 1 ; v <= vertices - 1 ; v++){
			for(int i = 0 ; i < adjMat.length ; i++){
				for(int j = 0 ; j < adjMat[i].length ; j++){
					if(adjMat[i][j] != 0){
						int src = i ; 
						int dest= j ;
						int weight = adjMat[src][dest];
						if(dist[src] != Integer.MAX_VALUE && dist[src] + weight < dist[dest]){
							dist[dest] = dist[src] + weight;
							parent[dest] = src ; 
						}
					}
				}
			}
		}
		System.out.println(Arrays.toString(parent));
		return dist;
	}
	
	/**
	 * Floyd Warshall Algorithm
	 * @param graph
	 * @return
	 */
	public static int[][] floydWarshallAlgo(GraphAdjMatDirected graph){
		int INF = Integer.MAX_VALUE;
		int[][] adjMat = { {0,   5,  INF, 10},
                {INF,  0,  3,  INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0} };
		
		int vertices = adjMat.length;
		
		for (int k = 0; k < vertices; k++)
	    {
	        // Pick all vertices as source one by one
	        for (int i = 0; i < vertices; i++)
	        {
	            // Pick all vertices as destination for the
	            // above picked source
	            for (int j = 0; j < vertices; j++)
	            {
	                // If vertex k is on the shortest path from
	                // i to j, then update the value of dist[i][j]
	                if (adjMat[i][k] != INF && adjMat[k][j] != INF && adjMat[i][k] + adjMat[k][j] < adjMat[i][j])
	                	adjMat[i][j] = adjMat[i][k] + adjMat[k][j];
	            }
	        }
	    }
		return adjMat;
	}
}
