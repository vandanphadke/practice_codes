import java.util.Arrays;

/**
 * Q: Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function 
 * search(char pat[], char txt[]) that prints all occurrences of pat[] 
 * and its permutations (or anagrams) in txt[]. You may assume that n > m.
 * @author Vandan Phadke
 *
 */
public class AnagramSubstringSearch {
	public static void main(String[] args) {
		String text = "BACDGABCDA";
		String pattern = "ABCD";		
		searchAnagram(text, pattern);
	}
	
	public static void searchAnagram(String text, String pattern){
		int[] freqtext = new int[26];
		int[] freqpattern = new int[26];
		char[] pat = pattern.toCharArray();
		char[] t = text.toCharArray();
		int n = pat.length ; 
		
		for(int i = 0 ; i < n ; i++){
			++freqpattern[pat[i] - 'A'];
			++freqtext[t[i] - 'A'];
		}
		
		if(Arrays.equals(freqpattern, freqtext)){
			System.out.println("Index 0");
		}
		
		for(int i = 0 ; i < t.length - n ; i++){
			--freqtext[t[i] - 'A'];
			++freqtext[t[i + n] - 'A'];
			if(Arrays.equals(freqpattern, freqtext)){
				System.out.println("Index " + (i+1));
			}
		}
	}
}
