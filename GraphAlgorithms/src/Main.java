import java.util.Arrays;

public class Main {
	/*public static void main(String[] args) {
		GraphAdjMatDirected graph = new GraphAdjMatDirected(5);
		graph.addVertex('a');graph.addVertex('b');graph.addVertex('c');
		graph.addVertex('d');graph.addVertex('e');
		graph.addEdge(0, 1, 1);graph.addEdge(0, 2, 1);graph.addEdge(1, 3, 1);
		graph.addEdge(2, 3, 1);
		System.out.println(graph.topologicalSort());
		//GraphAdjListDirected graph = new GraphAdjListDirected(3);
		graph.addEdge(0, 1, 1);//graph.addEdge(1, 2, 1);//graph.addEdge(0, 2, 1);
		//graph.addEdge(2, 0, 1);graph.addEdge(2, 3, 1);//graph.addEdge(3, 3, 1);
		graph.printGraph();
		System.out.println(graph.isCyclic());
		GraphAdjListUndirected graph = new GraphAdjListUndirected(3);
		graph.addEdge(0, 1, 1);
		graph.addEdge(1, 2, 1);
		graph.printGraph();
		System.out.println(graph.isCyclic());
	}*/
	
	public static void main(String[] args) {
		GraphAdjMatDirected g = new GraphAdjMatDirected(6);
		g.addEdge(0, 1, 5);g.addVertex('a');
	    g.addEdge(0, 2, 3);g.addVertex('b');
	    g.addEdge(1, 3, 6);g.addVertex('c');
	    g.addEdge(1, 2, 2);g.addVertex('d');
	    g.addEdge(2, 4, 4);g.addVertex('e');
	    g.addEdge(2, 5, 2);g.addVertex('f');
	    //System.out.println(Arrays.toString(ShortestPathAlgos.dijkstrasAlgo(g, 0)));
	    //System.out.println(Arrays.toString(ShortestPathAlgos.bellmanFordAlgo(g, 0)));
	    int[][] mat = ShortestPathAlgos.floydWarshallAlgo(g);
	    for(int i = 0 ; i < mat.length ; i++)
	    	System.out.println(Arrays.toString(mat[i]));
	   
	}
}
