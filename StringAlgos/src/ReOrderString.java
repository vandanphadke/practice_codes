import java.util.Arrays;

/**
 * Q: Given a string of lowercase characters, reorder them such that the same characters 
 * are at least distance d from each other.
 * Input: { a, b, b }, distance = 2
 * Output: { b, a, b }
 * @author Vandan Phadke
 */
public class ReOrderString {
	public static void main(String[] args) {
		String s = "aaa";
		int d = 2 ;
		System.out.println(reOrder(s.toCharArray() , d));
	}
	
	public static String reOrder(char[] str, int d){
		int[] freq = new int[26];
		for(int i = 0 ; i < str.length ; i++)
			++freq[str[i] - 'a'];
		boolean[] isFilled = new boolean[str.length];
		while(getMaxFreqChar(freq) != -1){
			int pos = getMaxFreqChar(freq);
			int temp = freq[pos];
			int start = 0 ; 
			freq[pos] = 0 ;
			for(int j = 0 ; j < isFilled.length ; j++){
				if(!isFilled[j]){
					start = j ;
					break; 
				}
			}
			int i = 0 ; 
			while(temp > 0){
				if(start + (i * d) >= str.length)
					return null ;
				str[start + (i * d)] = (char) (pos + 'a');
				isFilled[start + (i * d)] = true;
				++i;--temp;
			}
		}
		return new String(str) ; 
	}
	
	public static int getMaxFreqChar(int[] freq){
		int max = Integer.MIN_VALUE, index = 0;
		for(int i = 0 ; i < freq.length ; i++){
			if(freq[i] == 0)
				continue ;
			if(freq[i] > max){
				max = freq[i] ;
				index = i ; 
			}
		}
		
		if(max == Integer.MIN_VALUE)
			return -1 ;
		return index;
	}
}
