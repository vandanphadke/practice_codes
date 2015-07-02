import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjMatDirected {
	public class Vertex{
		private char label;
		public boolean isVisited;
		public Vertex(char l){
			label = l ; 
			this.isVisited = false;
		}
		public void visit() {
			this.isVisited = true; 
		}
		public void displayVertex(){System.out.println(label);}
		
	}
	private int[][] adjMatrix ;
	private int max_vertex_count = 0 ;
	private Stack<Integer> stack;
	private Stack<Integer> stack_topological;
	private Queue<Integer> queue; 
	private Vertex[] vertex_list;
	private int count = 0 ; 
	
	public GraphAdjMatDirected(int max_vertex_count){
		this.max_vertex_count = max_vertex_count;
		adjMatrix = new int[max_vertex_count][max_vertex_count];
		vertex_list = new Vertex[max_vertex_count];
		stack = new Stack<Integer>();
		stack_topological = new Stack<Integer>();
		queue = new LinkedList<Integer>();
	}
	
	public void addVertex(char label){
		vertex_list[count++] = new Vertex(label);
	}
	
	public int getNoofVertices(){return max_vertex_count;}
	
	public void addEdge(int srcVertex, int destVertex, int weight) {
		if(srcVertex < 0 || srcVertex > max_vertex_count || destVertex < 0 || destVertex > max_vertex_count)
			throw new IllegalArgumentException("These vertices do not exist");
		
		adjMatrix[srcVertex][destVertex] = weight;
	}
	
	public void removeEdge(int srcVertex, int destVertex) {
		if(srcVertex < 0 || srcVertex > max_vertex_count || destVertex < 0 || destVertex > max_vertex_count)
			throw new IllegalArgumentException("These vertices do not exist");
		
		adjMatrix[srcVertex][destVertex] = 0;
	}
	
	public int getWeight(int srcVertex, int destVertex) {
		if(srcVertex < 0 || srcVertex > max_vertex_count || destVertex < 0 || destVertex > max_vertex_count)
			throw new IllegalArgumentException("These vertices do not exist");
		
		return adjMatrix[srcVertex][destVertex];
	}
	
	public void graphDFS(){
		vertex_list[0].visit();
		vertex_list[0].displayVertex();
		stack.push(0);
		while(!stack.isEmpty()){
			int v = getUnvisitedVertex(stack.peek());
			if(v == -1){
				//Add vertex to topological sort stack after every child has been visited
				stack_topological.push(stack.pop());
			}
			else{
				vertex_list[v].visit();
				vertex_list[v].displayVertex();
				stack.push(v);
			}
		}
		for(int i = 0 ; i < count; i++){
			vertex_list[i].isVisited = false; 
		}
	}
	
	public void graphBFS(){
		vertex_list[0].visit();
		vertex_list[0].displayVertex();
		queue.add(0);
		while(!queue.isEmpty()){
			int v = queue.remove();
			while(getUnvisitedVertex(v) != -1){
				int v2 = getUnvisitedVertex(v);
				vertex_list[v2].visit();
				vertex_list[v2].displayVertex();
				queue.add(v2);
			}
		}
		for(int i = 0 ; i < count; i++){
			vertex_list[i].isVisited = false; 
		}
	}

	private int getUnvisitedVertex(int vertex) {
	
		for(int j = 0 ; j < count; j++)
		{
			if(adjMatrix[vertex][j] > 0 && !vertex_list[j].isVisited)
				return j;
		}
		return -1;
	}
	
	public ArrayList<Integer> topologicalSort(){
		if(stack_topological.isEmpty())
			graphDFS();
		ArrayList<Integer> top_sorted_vertices = new ArrayList<Integer>();
		while(!stack_topological.isEmpty())
			top_sorted_vertices.add(stack_topological.pop());
		return top_sorted_vertices;
	}
}
