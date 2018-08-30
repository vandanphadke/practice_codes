/**
 *
 * Giving a dictionary and a string ‘str’, find the longest string in dictionary
 * which can be formed by deleting some characters of the given ‘str’.
 *
 * @author vandan
 */
public class LargestWordDictionary {

    public static void main(String[] args){
        String str1 = "abpcplea";
        String[] dictionary1 = {"ale", "apple", "monkey", "plea"};

        String str2 = "geeksforgeeks";
        String[] dictionary2 = {"pintu", "geeksfor", "geeksgeeks",
                " forgeek"};

        System.out.println(getLongestWord(str1, dictionary1));
        System.out.println(getLongestWord(str2, dictionary2));

    }


    public static String getLongestWord(String str, String[] dictionary){
        int maxIndex = Integer.MIN_VALUE;
        for (int i = 0 ; i < dictionary.length ; ++i){
            if (canWordBeFormed(str, dictionary[i])){
                if (maxIndex == Integer.MIN_VALUE){
                    maxIndex = i;
                }
                else {
                    if (dictionary[maxIndex].length() < dictionary[i].length())
                        maxIndex = i;
                }
            }
        }
        return dictionary[maxIndex];
    }

    public static boolean canWordBeFormed(String word, String dictEntry){
        if (dictEntry.length() == 0) return false;
        if (word.length() == 0) return true;

        int i = 0, j = 0;
        while (i < word.length() && j < dictEntry.length()){
            if (word.charAt(i) == dictEntry.charAt(j)){
                ++i;
                ++j;
            }
            else
                ++i;
        }

        if (j != dictEntry.length())
            return false;
        else
            return true;
    }
}
