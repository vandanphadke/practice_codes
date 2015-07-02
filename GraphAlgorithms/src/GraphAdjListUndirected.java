import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphAdjListUndirected {
	public  Map<Integer, ArrayList<Edge>> Adjacency_List;
	int no_of_vertices; 
	
	public GraphAdjListUndirected(int number_of_vertices) {
		this.no_of_vertices = number_of_vertices;
		Adjacency_List = new HashMap<Integer, ArrayList<Edge>>();	
        for (int i = 0 ; i < number_of_vertices ; i++)
            Adjacency_List.put(i, new ArrayList<Edge>());
        
	}
	
	public void addEdge(int source, int destination, int weight){
		if (source > Adjacency_List.size() || destination > Adjacency_List.size())
	       {
	           System.out.println("the vertex entered in not present ");
	           return;
	       }
	       ArrayList<Edge> slist = Adjacency_List.get(source);
	       slist.add(new Edge(destination, weight));
	       ArrayList<Edge> dlist = Adjacency_List.get(destination);
	       dlist.add(new Edge(source, weight));
	}
	
	public ArrayList<Edge> getEdges(int source)
    {
        if (source > Adjacency_List.size())
        {
            System.out.println("the vertex entered is not present");
            return null;
        }
        return Adjacency_List.get(source);
    }
	
	public boolean isEdge(int source, int destination){
		if (source > Adjacency_List.size() || destination > Adjacency_List.size())
			throw new IllegalArgumentException("Incorrect value is incorrect");
		
		ArrayList<Edge> srcList = Adjacency_List.get(source);
		
		for(Edge e: srcList){
			if(e.getDestination() == destination)
				return true; 
		}
		return false; 
	}
	
	public void printGraph() {
		for(int i = 0 ; i < no_of_vertices ; i++){
			for(Edge e: Adjacency_List.get(i))
				System.out.print(e.getDestination() +" "+e.getWeight() + " ");
			System.out.println();	
		}
	}
	
	public int getNoofVertices(){return Adjacency_List.size();}
}
