import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphAdjList {
	private  Map<Integer, ArrayList<Integer>> Adjacency_List;
	
	public GraphAdjList(int number_of_vertices) {
		Adjacency_List = new HashMap<Integer, ArrayList<Integer>>();	
        for (int i = 1 ; i <= number_of_vertices ; i++)
            Adjacency_List.put(i, new ArrayList<Integer>());
        
	}
	
	public void addEdge(int source, int destination){
		if (source > Adjacency_List.size() || destination > Adjacency_List.size())
	       {
	           System.out.println("the vertex entered in not present ");
	           return;
	       }
	       ArrayList<Integer> slist = Adjacency_List.get(source);
	       slist.add(destination);
	       ArrayList<Integer> dlist = Adjacency_List.get(destination);
	       dlist.add(source);
	}
	
	public ArrayList<Integer> getEdge(int source)
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
		
		ArrayList<Integer> srcList = Adjacency_List.get(source);
		
		if(srcList.contains(destination))
			return true; 
		else
			return false; 
	}
	
	public void printGraph() {
		System.out.println(Adjacency_List.toString());
	}
}
