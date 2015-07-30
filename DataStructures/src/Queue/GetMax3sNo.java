package Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Q: Given an array of non-negative integers. 
 * Find the largest multiple of 3 that can be formed from array elements.
 * @author Vandan Phadke
 *
 */
public class GetMax3sNo {
	public static void main(String[] args) {
		int[] arr = {8, 1, 9};
		Arrays.sort(arr);
		System.out.println(getMaxNo(arr));
	}
	
	public static ArrayList<Integer> getMaxNo(int[] no){
		Queue<Integer> q0 = new LinkedList<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		int sum = 0 ;
		for(int i = 0 ; i < no.length ; i++){
			sum += no[i];
			if(no[i] % 3 == 0)
				q0.add(no[i]);
			else if(no[i] % 3 == 1)
				q1.add(no[i]);
			else
				q2.add(no[i]);
		}
		
		if(sum % 3 == 1){
			if(!q1.isEmpty())
				q1.poll();
			else{
				if(!q2.isEmpty())
					q2.poll();
				else
					return null;
				
				if(!q2.isEmpty())
					q2.poll();
				else
					return null;
			}
		}
		
		else if(sum % 3 == 2){
			if(!q2.isEmpty())
				q1.poll();
			else{
				if(!q1.isEmpty())
					q1.poll();
				else
					return null;
				
				if(!q1.isEmpty())
					q1.poll();
				else
					return null;
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>(q0);
		arr.addAll(q1);arr.addAll(q2);
		Collections.sort(arr);
		return arr; 
	}
}
