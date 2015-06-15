
public class Main {
	public static void main(String[] args) {
		GraphAdjMat graph = new GraphAdjMat(5);
		graph.addVertex('A');graph.addVertex('B');graph.addVertex('C');
		graph.addVertex('D');graph.addVertex('E');
		graph.addEdge(0, 1, 1);graph.addEdge(0, 2, 1);graph.addEdge(1, 3, 1);
		graph.addEdge(3, 4, 1);
		graph.graphDFS();
	}
}
