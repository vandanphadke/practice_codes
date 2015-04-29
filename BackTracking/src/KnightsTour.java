public class KnightsTour {
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		Knightstour();
		double end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start)/1000);
	}
	
	public static boolean isSafe(int[][] board, int row, int column)
	{
		if(row >=0 && column >=0 && row < board.length && column < board.length && board[row][column] == -1)
			return true ; 
		
		return false ; 
	}
	
	public static boolean recurseKnight(int[][] board, int[] xMove, int[] yMove, int x, int y, int moveNo)
	{
		if(moveNo == board.length*board.length)
			return true; 
		
		for(int k = 0 ; k < 8 ;k++)
		{
			int next_x = x + xMove[k];
			int next_y = y + yMove[k];
			
			if(isSafe(board, next_x, next_y))
			{
				board[next_x][next_y] = moveNo ;
				if(recurseKnight(board, xMove, yMove, next_x, next_y, moveNo + 1))
				{
					return true ; 
				}
				else
					board[next_x][next_y] = -1 ; 
			}
			
		}
		
		return false ;
	}
	
	public static void Knightstour()
	{
		int[][] board = new int[8][8];
		
		for(int i = 0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board.length ;j++)
				board[i][j] = -1;
		}
		
		int[] xMove = {2,1,-1,-2,-2,-1,1,2};
		int[] yMove = {1,2,2,1,-1,-2,-2,-1};
		
		board[0][0] = 0 ; 
		
		recurseKnight(board, xMove, yMove, 0, 0, 1);
		
		for(int i = 0 ; i < board.length ; i++)
		{
			for(int j = 0 ; j < board.length ;j++)
				System.out.print(board[i][j] + "\t");
			System.out.println();
		}
		
	}
	
}
