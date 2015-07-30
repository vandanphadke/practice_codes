import java.util.ArrayList;
import java.util.List;

public class LetterCombinarions {
	static String[] map = {""," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static void main(String[] args) {
		String s = "2";
		System.out.println(combinations(s));
	}
	
	public static List<String> combinations(String s){
		List<String> list = new ArrayList<String>();
		List<String> words = new ArrayList<String>();
		for(int i = 0 ; i < s.length() ; i++){
			if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 8)
				words.add(map[s.charAt(i) - '0']);
		}
		int length = words.size();
		generate(list, new String(), 0, length, words);
		return list ;
	}
	
	public static void generate(List<String> list, String s, int l, int length, List<String> words){
		//System.out.println(l + " str is" + s);
		if(l >= length){
			list.add(s);
			return ; 
		}
		
		for(int i = 0 ; i < words.get(l).length() ; ++i){
			char c = words.get(l).charAt(i);
			generate(list, s + c, l + 1, length, words);
		}
	}
}
