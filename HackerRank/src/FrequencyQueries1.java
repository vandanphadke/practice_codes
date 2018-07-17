import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class FrequencyQueries1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] queries = new int[n][2];
        int noOutput = 0;
        for (int i = 0; i < n; ++i){
            String[] content = br.readLine().split(" ");
            queries[i][0] = Integer.parseInt(content[0]);
            queries[i][1] = Integer.parseInt(content[1]);

            if (queries[i][0] == 3)
                ++noOutput;

        }

        int[] ans = solveQueries(queries, noOutput);
        for (int i = 0; i < ans.length; i++) {
            if (i == ans.length - 1)
                System.out.print(String.valueOf(ans[i]));
            else
                System.out.println(String.valueOf(ans[i]));

        }


    }

    private static int[] solveQueries(int[][] queries, int noOutput) {
        HashMap<Integer, Integer> numFreq = new HashMap<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] out = new int[noOutput];
        int current = 0;
        for(int i = 0 ; i < queries.length; ++i){
            int action = queries[i][0];
            int number = queries[i][1];

            if(action == 1){
                if(numFreq.containsKey(number)) {
                    int mx = numFreq.get(number);

                    numFreq.put(number, mx+1);

                    int c = freq.get(mx);
                    if(c == 1) {
                        freq.remove(mx);
                    }
                    else {
                        freq.put(mx, c-1);
                    }

                    if(!freq.containsKey(mx+1)) {
                        freq.put(mx+1, 1);
                    }
                    else {
                        c = freq.get(mx+1);
                        freq.put(mx+1, c+1);
                    }
                }
                else {
                    numFreq.put(number, 1);

                    if(!freq.containsKey(1)) {
                        freq.put(1, 1);
                    }
                    else {
                        freq.put(1, freq.get(1)+1);
                    }
                }
            }
            else if(action == 2){
                if(numFreq.containsKey(number)) {
                    int mx = numFreq.get(number);

                    if(mx == 0)
                        numFreq.remove(number);
                    else
                        numFreq.put(number, mx-1);

                    int c = freq.get(mx);
                    if(c == 1) {
                        freq.remove(mx);
                    }
                    else {
                        freq.put(mx, c-1);
                    }

                    if(!freq.containsKey(mx-1)) {
                        freq.put(mx-1, 1);
                    }
                    else {
                        c = freq.get(mx-1);
                        freq.put(mx-1, c+1);
                    }
                }
            }
            else if (action == 3){
                if (freq.containsKey(number))
                    out[current] = 1;
                else
                    out[current] = 0;
                ++current;
            }
            else
                continue;
        }
        return out;
    }
}
