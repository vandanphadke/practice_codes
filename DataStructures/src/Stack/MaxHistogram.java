package Stack;

import java.util.Stack;

/**
 * Q: Find the largest rectangular area possible in a given histogram where the largest 
 * rectangle can be made of a number of contiguous bars
 * @author Vandan Phadke
 *
 */
public class MaxHistogram {
	public static void main(String[] args) {
		int[] graph = {2,2,2,6,1,5,4,2,2,2,2};
		System.out.println(getMaxAres(graph));
	}
	
	public static int getMaxAres(int[] hist){
		Stack<Integer> stack = new Stack<Integer>();
		int max_area = Integer.MIN_VALUE, area = 0;
		int i = 0 ; 
		while( i < hist.length){
			if(stack.isEmpty() || hist[stack.peek()] <= hist[i])
				stack.push(i++);
			else{
				int top = stack.pop();
				if(stack.isEmpty())
					area = i * (hist[top]);
				else
					area = (i - stack.peek() - 1) * hist[top] ;
				if(area > max_area)
					max_area = area;
					
			}
		}
		
		while(!stack.isEmpty()){
			int top = stack.pop();
			if(stack.isEmpty())
				area = i * (hist[top]);
			else
				area = (i - stack.peek() - 1) * hist[top] ;
			if(area > max_area)
				max_area = area;
			
		}
		return max_area; 
	}
	
}
