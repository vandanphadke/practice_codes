import java.util.HashSet;

/**
 * Q: Given an input string and a dictionary of words, find out if the input string 
 * can be segmented into a space-separated sequence of dictionary words
 * @author Vandan Phadke
 *
 */
public class WordBreak {
	public static void main(String[] args) {
		System.out.println(checkwordbreak("mobileImobileI"));
	}
	
	public static boolean dictionaryContains(String word){
		HashSet<String> set = new HashSet<String>();
		set.add("mobile");
		set.add("I");
		return (set.contains(word));
	}
	
	public static boolean checkwordbreak(String str){
		int size = str.length();
		boolean[] arr = new boolean[size + 1];
		
		for(int i = 1 ; i <= size; i++){
			if(arr[i] == false && dictionaryContains(str.substring(0, i)))
				arr[i] = true;
			
			if(arr[i] == true){
				if(i == size)
					return true;
				
				for(int j = i + 1 ; j <= size ; j++){
					if(arr[j] == false && dictionaryContains(str.substring(i, j-i)))
						arr[j] = true;
					
					if(j == size && arr[j] == true)
						return true; 
						
				}
			}
		}
		return false; 
	}
}
