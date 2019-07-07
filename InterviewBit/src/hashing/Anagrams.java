package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < a.size(); i++){
            char[] c = a.get(i).toCharArray();
            Arrays.sort(c);
            String t = String.valueOf(c);
            if(map.get(t) == null){
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i+1);
                map.put(t, l);
            }
            else
                map.get(t).add(i + 1);
        }
        for(ArrayList<Integer> l : map.values()){
            result.add(l);
        }

        return result;
    }
}
