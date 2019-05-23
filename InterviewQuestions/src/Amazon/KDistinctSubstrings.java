package Amazon;

import java.util.HashSet;
import java.util.Set;

//23280674047307
public class KDistinctSubstrings {

    public int getDistictSubstrings(String s, int k){
        char[] ScharArr = s.toCharArray();
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; ++i){
            Set<Character> distinct = new HashSet<>();
            for (int j = i; j < n; ++j){
                distinct.add(ScharArr[j]);
                if (distinct.size() == k)
                    ++count;
                else if (distinct.size() > k)
                    break;
            }
        }
        return count;
    }
}
