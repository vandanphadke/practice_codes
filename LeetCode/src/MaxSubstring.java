import java.util.Arrays;

/**
 * 
 * @author Vandan Phadke
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for “abcabcbb” is “abc”, 
 * which the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1.
 */
public class MaxSubstring {
	public static void main(String[] args) {
		String s = new String("abcabcbb");
		System.out.println(maxSubstr(s));
	}
	
	public static int maxSubstr(String s){
		int i = 0 , j = 0 ;
		boolean[] freq = new boolean[26];
		Arrays.fill(freq, false);
		int max = Integer.MIN_VALUE;
		while(j < s.length()){
			if(!freq[s.charAt(j) - 'a']){
				freq[s.charAt(j) - 'a'] = true; 
				j++;
			}
			else{
				max = Math.max(j - i, max);
				while(s.charAt(i) != s.charAt(j)){
					freq[s.charAt(i) - 'a'] = false;
					++i; 
				}
				++i;++j;
			}
		}
		max = Math.max(s.length() - i , max);
		return max ; 
	}
}
