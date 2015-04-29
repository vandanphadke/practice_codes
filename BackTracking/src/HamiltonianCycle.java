import java.util.Arrays;

public class HamiltonianCycle {
	
	public static void main(String[] args) {
		int[][] graph2 = {{0, 1, 0, 1, 0},
                          {1, 0, 1, 1, 1},
                          {0, 1, 0, 0, 1},
                          {1, 1, 0, 0, 0},
                          {0, 1, 1, 0, 0},};
		
		solveHamiltonianCycle(graph2);
		
	}
	
	public static boolean isSafe(int v, int[][] graph, int[] path, int pos)
	{
		
		//Check if edge exists from last vertex to the chosen vertex
		if( graph[path[pos - 1]][v] == 0)
			return false ; 
		
		//Check if the vertex is already visited
		for(int i = 0 ; i < pos ; i++)
			if(path[i] == v)
				return false ;
		
		return true; 
	}
	
	public static boolean recurseHamiltonian(int[][] graph, int last_visited , int[] visited)
	{
		if( last_visited == graph.length )
		{
			if(graph[visited[last_visited - 1]][visited[0]] == 1)
				return true; 
			else
				return false ; 
		}
		
		for(int i = 0 ; i < graph.length ; i++)
		{
			if(isSafe(i, graph, visited, last_visited))
			{
				visited[last_visited] = i ; 
				
				if(recurseHamiltonian(graph, last_visited + 1, visited))
					return true ; 
				
				visited[last_visited] = -1 ; 
				
			}
			
		}
		
		return false ; 	
	}
	
	public static void solveHamiltonianCycle(int[][] graph)
	{
		int[] visited = new int[graph.length];
		Arrays.fill(visited, -1);
		
		visited[0] = 0 ;
		
		if(recurseHamiltonian(graph, 1, visited) == true)
		{
			System.out.println("Solution exists");
			for(int i = 0 ; i < visited.length ; i++)
				System.out.print(i + "\t");
		}
		
		else
			System.out.println("Solution doesnt exist");
		
	}
}
