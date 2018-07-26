package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Question: https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 *
 *
 */
public class SherlockAndValidString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        System.out.println(checkIfValid(line));
    }

    private static String checkIfValid(String s) {
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length(); ++i)
            ++freq[s.charAt(i) - 'a'];


        HashMap<Integer, Integer> freqCum = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < 26; ++i){
            if(freq[i] != 0){
                if(freqCum.containsKey(freq[i]))
                    freqCum.put(freq[i], freqCum.get(freq[i]) + 1);
                else
                    freqCum.put(freq[i], 1);
            }
        }

        if(freqCum.size() > 2)
            return "NO";
        else{
            if(freqCum.size() == 1)
                return "YES";
            else {
                List<Integer> vals = new ArrayList<>();
                for(Integer i: freqCum.keySet())
                    vals.add(i);

                int f1 = vals.get(0);
                int f2 = vals.get(1);
                int f1Count = 0, f2Count = 0;


                for(int i = 0 ; i < freq.length; ++i) {
                    if(freq[i] == f1) f1Count++;
                    if(freq[i] == f2) f2Count++;
                }

                if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                    return "YES";
                else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                    return "YES";
                else
                    return "NO";

            }
        }

    }

}
