
public class NQueens {
	public static void main(String[] args) {
		double start = System.currentTimeMillis();
		int[][] chessBoard = new int[30][30];
		solveNQueens(chessBoard);
		double end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start)/1000);
	}
	
	public static boolean isSafe(int[][] board, int row, int column)
	{
		for(int i = 0 ; i < column ; i++)
			if(board[row][i] == 1)
				return false;
		
		for(int i = column, j = row; i >= 0 && j >= 0 ; i--,j--)
			if(board[j][i] == 1)	return false ;
		
		for(int i = row, j = column; j >= 0 && i < board.length ; i++,j--)
			if(board[i][j] == 1)	return false ; 
		
		return true ; 
	}
	
	public static boolean nQueenRecurse(int[][] board, int column){
		if(column >= board.length)
			return true ; 
		
		for(int i = 0 ; i < board.length ; i++)
		{
			if(isSafe(board, i, column))
			{
				board[i][column] = 1 ;
				
				if(nQueenRecurse(board, column + 1))
				{
					return true ;
				}
				
				board[i][column] = 0 ; 
			}
		}
		return false ; 
	}
	
	public static void solveNQueens(int[][] board){
		System.out.println(nQueenRecurse(board, 0));
		for(int i = 0 ; i < board.length ; i++)
		{	
			for(int j = 0 ; j < board.length ; j++)
				System.out.print(board[i][j]);
			System.out.println();
		}
				
		
	}
}
