public class Path {
	public static void main(String[] args) {
		int[][] path = {{1,0,0,0}
			           ,{1,1,1,1}
			           ,{1,0,0,1}
			           ,{1,0,1,1}};
		
		solvePath(path);
	}
	
	public static boolean isSafe(int[][] path, int x, int y)
	{
		if(x >= 0 && x <= path.length - 1 && y >= 0 && y < path.length - 1 && path[x][y] == 1)
			return true ;
		return false; 
	}
	
	public static boolean pathRecurse(int[][] path, int xPos, int yPos, int[][] sol){
		
		if(xPos == path.length - 1 && yPos == path.length - 1){
			sol[xPos][yPos] = 1 ; 
			return true ;	
		}
		
		if(isSafe(path, xPos, yPos))
		{
			sol[xPos][yPos] = 1 ;
			if(pathRecurse(path, xPos , yPos + 1, sol))
				return true ;
			
			if(pathRecurse(path, xPos + 1 , yPos, sol))
				return true ;
			
			sol[xPos][yPos] = 0 ;  
		}

		return false ; 
	}
	
	public static void solvePath(int[][] path)
	{
		int[][] sol = new int[path.length][path.length];
		if(path[0][0] == 0)
		{
			System.out.println("No starting point");
			return ; 
		}
		
		if(pathRecurse(path, 0, 0, sol))
		{
			System.out.println("Path exists"); 
			for(int i = 0 ; i < sol.length ; i++)
			{
				for(int j = 0 ; j < sol.length ; j++)
					System.out.print(sol[i][j] + "\t");
				System.out.println();
			}
		}
		else
			System.out.println("Path does not exist");
	}
}
