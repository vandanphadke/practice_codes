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
		
		QueueVertex v = null ; 
		while(!queue.isEmpty()){
			v = queue.poll();
			int vertex = v.vertex;
			
			if(vertex == n - 1)
				break;
			
			for(int j = vertex + 1 ; j <= vertex + 6 && j < n ; j++){
				if(!visited[j]){
					QueueVertex a = new QueueVertex(0, 0);
					a.distance = v.distance + 1 ; 
					visited[j] = true; 
					
					if(moves[j] != -1)
						a.vertex = moves[j];
					else
						a.vertex = j ;
					
					queue.add(a);
				}
			}
		}
		return v.distance ;
	}
}

class QueueVertex{
	int vertex, distance;
	public QueueVertex(int v, int d) {
		vertex = v ; 
		distance = d ;
	}
}
