import java.util.Arrays;


public class StringAnagrams {
	public static void main(String[] args) {
		printAnagrams("ABC");
	}
	
	public static void printAnagrams(String s){
		printAnagramsRecurse(s.toCharArray(), 0, s.length() - 1);
	}
	
	public static void printAnagramsRecurse(char[] s, int start, int end){
		if(end == start){
			System.out.println(Arrays.toString(s));
		}
		else{
			for(int i = start ; i <= end ; i++){
				swap(s, start, i);
				printAnagramsRecurse(s, start + 1, end);
				swap(s, start, i);
			}
		}
	}
	
	public static void swap(char[] s, int a, int b){
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp; 
	}
}
