package Heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinAvgWaitTIme {
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		String[] line;
		Pizza[] pizzas = new Pizza[n];
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		for(int i = 0 ; i < n ; i++){
			line = in.readLine().split(" ");
			pizzas[i] = new Pizza(Long.parseLong(line[0]), Long.parseLong(line[1]));
		}
		Arrays.sort(pizzas);
		long res = 0, time = 0 ;
		int i = 0 ; 
		while(!q.isEmpty() || (i < n)){
			if(q.isEmpty() && i < n){
				time = Math.max(time, pizzas[i].arrival);
			}
			while(i < n && pizzas[i].arrival <= time){
				res += (time - pizzas[i].arrival) ;
				q.add(pizzas[i].work);
				++i;
			}
			long min = q.poll();
			res += (q.size() + 1) * min ;
			time += min ; 
		}
		System.out.println(res / n);
	}
	
}

class Pizza implements Comparable<Pizza>{
	long arrival, work; 
	public Pizza(long arrival, long work) {
		this.arrival = arrival;
		this.work = work;
	}
	
	public int compareTo(Pizza other) {
		return Long.compare(this.arrival, other.arrival);
	}
}
