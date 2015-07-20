import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Q: Given a snake and ladder board, find the minimum number of dice throws required 
 * to reach the destination 
 * @author Vandan Phadke
 *
 */
public class SnakeLadderProblem {
	public static void main(String[] args) {
		int[] moves = new int[30];
		Arrays.fill(moves, -1);
		
		// Ladders
	    moves[2] = 21;
	    moves[4] = 7;
	    moves[10] = 25;
	    moves[19] = 28;
	 
	    // Snakes
	    moves[26] = 0;
	    moves[20] = 8;
	    moves[16] = 3;
	    moves[18] = 6;
	    
	    System.out.println(getMinimumMover(moves));
	}
	
	public static int getMinimumMover(int[] moves){
		int n = moves.length ; 
		boolean[] visited = new boolean[n];
		Queue<QueueVertex> queue = new LinkedList<QueueVertex>();
		queue.add(new QueueVertex(0, 0));
		visited[0] = true; 
		return 0 ; 
	}
}

class QueueVertex{
	int vertex, distance;
	public QueueVertex(int v, int d) {
		vertex = v ; 
		distance = d ;
	}
}
