
public class WordSearch {
	
	public static void main(String[] args) {
		char[][] c = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
		String word = "ABE";
		System.out.println(exist(c, word));
	}
	
	public static boolean exist(char[][] board, String word) {
		return existRecurse(board, word.toCharArray(), 0, 0, 0);
    }
	
	public static boolean isSafe(char[][] board, char[] word, int x, int y, int pos){
		if(x < board.length && x >= 0 && y < board.length && y >= 0 && 
				word[pos] == board[x][y])
			return true;
		
		return false; 
	}
	
	public static boolean existRecurse(char[][] board, char[] word, int x, int y, int pos){
		if(pos == word.length)
			return true;
		
		if(isSafe(board, word, x, y, pos)){
			return (existRecurse(board, word, x+1, y, pos+1)   || 
					existRecurse(board, word, x-1, y, pos+1)   || 
					existRecurse(board, word, x, y+1, pos+1) ||
					existRecurse(board, word, x, y-1, pos+1)   ||
					existRecurse(board, word, x+1, y+1, pos+1)   ||
					existRecurse(board, word, x+1, y-1, pos+1)   ||
					existRecurse(board, word, x-1, y+1, pos+1)   ||
					existRecurse(board, word, x-1, y-1, pos+1)   
					);
		}
		else
			return false;
	}
}
