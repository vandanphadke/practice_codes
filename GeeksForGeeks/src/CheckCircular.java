/**
 * Q: Given a sequence of moves for a robot, check if the sequence is circular or not. 
 * A sequence of moves is circular if first and last positions of robot are same. 
 * A move can be on of the following.

   G - Go one unit
   L - Turn left
   R - Turn right 
 * @author Vandan Phadke
 *
 */
public class CheckCircular {
	
	//0 = N, 1 = W, 2 = S, 3 = E
	public static void main(String[] args) {
		char[] seq = new char[]{'G', 'L', 'L', 'G', 'R'};
		int dir = 0 ;
		int x = 0 , y = 0 ;
		
		for(int i = 0 ; i < seq.length ; i++){
			if(seq[i] == 'L'){
				dir = (dir+1) % 4 ; 
			}
			else if(seq[i] == 'R'){
				dir = (4 + dir - 1) %4; 
			}
			else if(seq[i] == 'G'){
				if(dir == 0)
					y++;
				else if(dir == 1)
					x--;
				else if(dir == 2)
					y--;
				else if(dir == 3)
					x++;
			}
		}
		if(x == 0 && y == 0)
			System.out.println("Circular");
		else
			System.out.println("Not circular");
	}
}
