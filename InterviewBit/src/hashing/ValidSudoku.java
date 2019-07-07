package hashing;

import java.util.List;

public class ValidSudoku {
    public static int isValidSudoku(final List<String> a) {
        int[] col = new int[9];
        int[] box = new int[9];
        for(int i = 0; i < 9; i++){
            int row = 0;

            for(int j = 0; j < 9; j++){
                if(a.get(i).charAt(j) == '.')
                    continue;
                int bit = 1 << (a.get(i).charAt(j) - '1');
                int box_index = i/3*3 + j/3;
                if((bit & row) != 0 || (bit & col[j]) != 0 || (bit & box[box_index]) != 0){
                    return 0;
                }
                row |= bit;
                col[j] |= bit;
                box[box_index] |= bit;
            }
        }
        return 1;
    }

}
