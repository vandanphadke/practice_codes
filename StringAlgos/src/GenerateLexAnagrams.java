import java.util.Arrays;

/**
 * Q: Generate the anagrams of a string in an lexicographic order
 * @author Vandan Phadke
 *
 */
public class GenerateLexAnagrams {
	public static void main(String[] args) {
		String s = "ABCD";
		char[] a = s.toCharArray();
		generateAllAnagrams(a);
	}
	
	public static void generateAllAnagrams(char[] str){
		Arrays.sort(str);
		int size = str.length;
		boolean isFinished = false;
		while(!isFinished){
			System.out.println(new String(str));
			int i;
			for(i = size - 2 ; i >= 0 ; --i){
				if(str[i] < str[i+1])
					break;
			}
			//System.out.println(i);	
			if(i == -1)
				isFinished = true;
			else{
				int second = findSecond(str, str[i], i + 1, size - 1);
				//System.out.println(second);
				swap(str, i, second);
				reverse(str, i + 1, size - 1 );
			}
		}
	}
	
	public static int findSecond(char[] str, char first, int l, int h){
		int index = l ; 
		for(int i = l + 1 ; i <= h ; i++){
			if(str[i] > first && str[i] < str[index])
				index = i; 
		}
		return index; 
	}
	
	public static void swap(char[] str, int a, int b){
		char temp = str[a];
		str[a] = str[b];
		str[b] = temp; 
	}
	
	public static void reverse(char[] str, int start, int end){
		while(start < end){
			swap(str, start, end);
			++start;
			--end;
		}
	}
}
