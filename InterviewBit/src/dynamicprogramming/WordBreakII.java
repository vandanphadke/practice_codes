package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a
 * sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 *
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is
 *
 * [
 *   "cat sand dog",
 *   "cats and dog"
 * ]
 */
public class WordBreakII {
    public static void main(String[] args){
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreakAnother(s, dict));

    }


    public static ArrayList<String> wordBreakAnother(String s, List<String> dict){
        boolean[] t = new boolean[s.length()+1];
        t[0] = true;

        ArrayList<ArrayList<Integer>> indexes = new ArrayList<>();
        for (int i = 0; i <= s.length(); ++i){
            indexes.add(new ArrayList<>());
        }

        for(int i=0; i<s.length(); i++){
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                    indexes.get(end).add(i);
                }
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        buildIndexes(res, current, indexes, s.length());
        ArrayList<String> finalRes = new ArrayList<>();
        for (ArrayList<Integer> single : res){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < single.size() - 1; ++j){
                sb.append(s, single.get(j), single.get(j+1));
                sb.append(" ");
            }
            sb.append(s.substring(single.get(single.size() - 1)));
            finalRes.add(sb.toString().trim());
        }

        return finalRes;
    }

    public static void buildIndexes(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> current,
                                    ArrayList<ArrayList<Integer>> indexes, int index){
        if (index == 0){
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < indexes.get(index).size(); ++i){
            int ind = indexes.get(index).get(i);
            current.add(0, ind);
            buildIndexes(res, current, indexes, ind);
            current.remove(0);
        }
    }
}
