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
	    g.addEdge(2, 3, 7);g.addEdge(3, 4, -1);
	    g.addEdge(3, 5, 1);g.addEdge(4, 5, -2);
	    System.out.println(Arrays.toString(LongestPathDag.getLongestPathDAG(g, 0)));
	    
	}
}
