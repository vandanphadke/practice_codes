import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T > 0){
            --T;
            String[] contents = br.readLine().split(" ");
            int r = Integer.parseInt(contents[0]);
            int c = Integer.parseInt(contents[1]);

            contents = br.readLine().split(" ");
            int[][] mat = new int[r][c];
            for (int i = 0; i < r; ++i){
                for (int j = 0; j < c; ++j){
                    mat[i][j] = Integer.parseInt(contents[i*r + j]);
                }
            }
            System.out.println(calculateTime(mat, r, c));
        }
    }

    private static int calculateTime(int[][] mat, int r, int c) {
        Queue<Integer> orangesQueue = new LinkedList<>();
        for (int i = 0; i < r; ++i){
            for (int j = 0; j < c; ++j){
                if (mat[i][j] == 2)
                    orangesQueue.offer(i*r + j);
            }
        }
        orangesQueue.offer(-1);
        int time = 0, currentIndex = 0, row = 0, column = 0;
        while (!orangesQueue.isEmpty()){
            currentIndex = orangesQueue.poll();
            column = currentIndex % r;
            row = (currentIndex - column) / r;



        }

        return 0;
    }


    public static void markOrange(int[][] mat,Queue<Integer> orangesQueue, int r, int c){

    }


}
