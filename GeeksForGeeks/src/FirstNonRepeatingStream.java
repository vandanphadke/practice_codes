import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingStream {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0){
            --t;
            int[] freq = new int[26];
            int totalNum = Integer.parseInt(br.readLine());
            char[] stream = new char[totalNum];
            Queue<Character> charQueue = new LinkedList<>();

            String[] content = br.readLine().split(" ");
            for (int i = 0; i < content.length; ++i){
                stream[i] = content[i].charAt(0);
            }


            for (int i = 0 ; i < stream.length; ++i){
                ++freq[stream[i] - 'a'];
                charQueue.offer(stream[i]);

                while (!charQueue.isEmpty()){
                    char next = charQueue.peek();
                    if (freq[next - 'a'] == 1){
                        System.out.println(next + " ");
                        break;
                    }
                    else
                        charQueue.poll();

                }

                System.out.print(-1 + " ");
            }
        }
        System.out.println();
    }

}
