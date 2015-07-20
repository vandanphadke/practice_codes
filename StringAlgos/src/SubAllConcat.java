import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Q: You are given a string, s, and a list of words, words, 
 * that are all of the same length. Find all starting indices of substring(s) in s 
 * that is a concatenation of each word in words exactly once and without any 
 * intervening characters
 * @author Vandan Phadke
 *
 */
public class SubAllConcat {
	public static void main(String[] args) {
		String s = "vvpabcfghasdqewe";
		String[] words = {"abc", "fgh"};
		
		System.out.println(findSubstring(s, words));
	}
	
	@SuppressWarnings("unchecked")
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        HashMap<String, Integer> stringNum = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i ++) {
            if (stringNum.containsKey(words[i]) == true) {
                int num = stringNum.get(words[i]);
                stringNum.replace(words[i], num, num + 1);
            } else {
                stringNum.put(words[i], 1);
            }
        }
        HashMap<String, Integer> workHash = (HashMap<String, Integer>) stringNum.clone();
        int itemLength = words[0].length();
        int totalLength = itemLength * words.length;
        for (int i = 0; i <= s.length() - totalLength; i ++) {
            String current = s.substring(i, i + totalLength);
            if (isConcat(current, itemLength, workHash) == true) {
                result.add(i);
            }
            workHash = (HashMap<String, Integer>) stringNum.clone();
        }
        return result;
    }
    public static boolean isConcat(String s, int pace, HashMap<String, Integer> hash) {
        for (int i = 0; i < s.length(); i += pace) {
            String sub = s.substring(i, i + pace);
            if (hash.containsKey(sub) == true && hash.get(sub) >= 0) {
                int num = hash.get(sub);
                hash.replace(sub, num, num - 1);
                if (hash.get(sub) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
