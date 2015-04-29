public class SudokuSolver {
	
	static int rRow = 0 , rColumn = 0 ; 
	public static void main(String[] args) {
		int[][] grid = 
			   {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		solveSudoku(grid);
	}
	public static boolean isSafe(int[][] grid, int row, int column, int number)
	{
		if(isUsedInRow(grid, row, number) || 
		   isUsedInColumn(grid, column, number) || 
		   isUsedInBox(grid,row - (row % 3), column - (column%3), number))
			return false;
		
		return true; 
		
	}
	
	public static boolean isUsedInRow(int[][] grid, int row, int number)
	{
		for(int i = 0 ; i < grid.length ; i++)
			if(grid[row][i] == number)
				return false ;
		return true ;
	}
	
	public static boolean isUsedInColumn(int[][] grid, int column, int number)
	{
		for(int i = 0 ; i < grid.length ; i++)
			if(grid[i][column] == number)
				return false ;
		return true ;
	}
	
	public static boolean isUsedInBox(int[][] grid, int boxStartX, int boxStartY, int number)
	{
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++)
				if(grid[boxStartX + i][ boxStartY + j] == number)
					return false ; 
		return true ; 
	}
	
	public static boolean recurseSudoku(int[][] grid)
	{
		if(!findNextUnassigned(grid))
			return true ;
		
		for(int i = 1 ; i <=9 ; i++)
		{
			if(isSafe(grid, rRow, rColumn, i))
			{
				grid[rRow][rColumn] = i ; 
				
				if(recurseSudoku(grid))
					return true ; 
				
				grid[rRow][rColumn] = 0 ; 
			}
		}
		
		return false ;
	}
	
	public static boolean findNextUnassigned(int[][] grid)
	{
		for(int j = 0 ; j < grid.length ; j++)
		{
			for(int k = 0; k < grid.length ; k++)
			{
				if(grid[j][k] == 0)
				{
					rRow = j ; 
					rColumn = k ;
					return true ; 
				}
				
			}	
		}
		return false; 
	}
	
	public static void solveSudoku(int[][] grid)
	{
		if(recurseSudoku(grid) == true)
		{
			System.out.println("Solution exists");
			for(int i = 0 ; i < grid.length ; i++)
			{
				for(int j = 0 ; j < grid.length ; j++)
					System.out.print(grid[i][j] + " ");
				System.out.println();
			}
				
		}
		else
			System.out.println("Solution doesnt exist");
		
	}
}
