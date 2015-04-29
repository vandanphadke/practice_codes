public class GraphColour {

	public static void main(String[] args) {
		int[][] graph = {{0,1,1,1}
        			    ,{1,0,1,0}
        			    ,{1,1,0,1}
        			    ,{1,0,1,0}};
		
		solveGraphColouring(graph , 3);
	}
	public static boolean isSafe(int vertex, int[][] graph, int[] color, int c){
		
		for(int i = 0 ; i < color.length ; i++)
		{
			if(graph[vertex][i] == 1 && color[i] == c)
				return false ; 
		}
		return true ; 
	}
	
	public static boolean graphRecurse(int[][] graph, int m, int[] color, int v)
	{
		if(v == graph.length)
			return true; 
		
		for(int c = 1 ; c <= m ; c++)
		{
			if(isSafe(v, graph, color, c))
			{
				color[v] = c ;
				
				if(graphRecurse(graph, m, color, v + 1))
					return true ; 
				
				color[v] = 0 ; 
			}
		}
		
		return false; 
		
	}
	
	public static void solveGraphColouring(int[][] graph, int m)
	{
		int[] color = new int[graph.length];
		if(graphRecurse(graph, m, color, 0))
		{
			System.out.println("The graph can be coloured using " + m + "colours");
			for(int i = 0 ; i < color.length ; i++)
				System.out.print(color[i] + "\t");
		}
		
		else
			System.out.println("Cannot be coloured using " + m + "colours");
	}
}
