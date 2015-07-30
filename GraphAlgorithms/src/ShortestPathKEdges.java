/**
 * Q: Given a directed and two vertices ‘u’ and ‘v’ in it, 
 * find shortest path from ‘u’ to ‘v’ with exactly k edges on the path.
 * @author Vandan Phadke
 *
 */
public class ShortestPathKEdges {
	public static int getShortestPathKEdges(GraphAdjMatDirected graph, int u, int v, int k){
		int[][] adj = graph.getMatrix();
		int no = adj.length;
		int[][][] sp = new int[v][v][k+1];
		return 0; 
	}
}
