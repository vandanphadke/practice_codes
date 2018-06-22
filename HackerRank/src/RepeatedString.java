import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long n = Long.parseLong(br.readLine().trim());
        System.out.println(getAOccurrences(str, n));
    }

    public static long getAOccurrences(String s, long n){
        long noOccurSingle = s.chars().filter(ch -> ch == 'a').count();
        long completeStrings = (n - (n%s.length())) / s.length();
        long completeAs = noOccurSingle * completeStrings;
        for (int i = 0; i < (n%s.length()); ++i){
            if(s.charAt(i) == 'a')
                completeAs++;
        }
        return completeAs;
    }
}
