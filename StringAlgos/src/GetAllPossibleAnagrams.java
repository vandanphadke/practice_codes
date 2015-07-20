import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Q: Given an array of strings, return all groups of strings that are anagrams.
 * @author Vandan Phadke
 *
 */
public class GetAllPossibleAnagrams {
	public static void main(String[] args) {
		System.out.println(anagrams(new String[]{"ABC", "OP", "BCA"}));
	}
	
	public static List<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String,Integer> anacheck = new HashMap<String,Integer>();
        String temp = "";
        int index = 0;
        for (String s : strs) {
                temp = sortstring(s);
                if (!anacheck.containsKey(temp)) {
                    anacheck.put(temp,index);
                }else {
                    int i = anacheck.get(temp);
                    if (i != -1) {
                        result.add(strs[i]);
                        anacheck.put(temp, -1);
                    }
                    result.add(s);
                }
            index++;
        }
        return result;
    }

     public static String sortstring(String s) {
            char[] c= s.toCharArray();
            Arrays.sort(c);
            return new String(c);
     }
}
