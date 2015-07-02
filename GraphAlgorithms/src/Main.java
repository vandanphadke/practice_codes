
public class Main {
	public static void main(String[] args) {
		GraphAdjMatDirected graph = new GraphAdjMatDirected(5);
		graph.addVertex('a');graph.addVertex('b');graph.addVertex('c');
		graph.addVertex('d');graph.addVertex('e');
		graph.addEdge(0, 1, 1);graph.addEdge(0, 2, 1);graph.addEdge(1, 3, 1);
		graph.addEdge(2, 3, 1);
		System.out.println(graph.topologicalSort());
	}
}
