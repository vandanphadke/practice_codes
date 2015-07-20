import java.util.Arrays;
import java.util.HashSet;

/**
 * Q: Given a string, find the length of the longest substring without repeating characters
 * @author Vandan Phadke
 *
 */
public class LongestSubstringNotRepeating {
	public static void main(String[] args) {
		System.out.println(getLongestSubstring("abdefgabef".toCharArray()));
	}
	
	public static int getLongestSubstring(char[] str){
		int n = str.length;
		int[] visited = new int[26];
		int current = 1, max_len = 1, prev = 0 ;
		Arrays.fill(visited, -1);
		
		visited[str[0] - 'a'] = 0 ;
		
		for(int i = 1 ; i < n ; i++){
			prev = visited[str[0] - 'a'];
			
			if(prev == -1 || i - current > prev)
				++current;
			else{
				if(current > max_len)
					max_len = current; 
				
				current = i - prev;
			}
			
			visited[str[i] - 'a'] = i ; 
		}
		
		if(current > max_len)
			max_len = current ; 
		
		return max_len; 
	}
}
