package graphdsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The cell itself
 * does not count as an adjacent cell.
 * The same letter cell may be used more than once.
 *
 * Example :
 *
 * Given board =
 *
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns 1,
 * word = "SEE", -> returns 1,
 * word = "ABCB", -> returns 1,
 * word = "ABFSAB" -> returns 1
 * word = "ABCD" -> returns 0
 * Note that 1 corresponds to true, and 0 corresponds to false.
 */
public class WordSearchBoard {
    public static void main(String[] args){
        List<String> arr = Arrays.asList("ABCE", "SFCS", "ADEE");
        System.out.println(doesWordExist(arr, "ABCCED"));
        System.out.println(doesWordExist(arr, "SEE"));
        System.out.println(doesWordExist(arr, "ABCB"));
        System.out.println(doesWordExist(arr, "ABFSAB"));
        System.out.println(doesWordExist(arr, "ABCD"));
    }

    public static int doesWordExist(List<String> mat, String word) {
        for (int i = 0; i < mat.size(); ++i){
            for (int j = 0; j < mat.get(0).length(); ++j){
                if (mat.get(i).charAt(j) == word.charAt(0)){
                    if (checkWord(mat, i, j, word, 0))
                        return 1;
                }
            }
        }
        return 0;
    }

    public static boolean checkWord(List<String> mat, int i, int j,
                                    String word, int index){
        if (index == word.length()) return true;

        if (i < 0 || i >= mat.size() || j < 0 || j >= mat.get(0).length()){
            return false;
        }
        if (mat.get(i).charAt(j) == word.charAt(index)){
            return checkWord(mat, i + 1, j, word, index + 1)
                    || checkWord(mat, i - 1, j, word, index + 1)
                    || checkWord(mat, i, j + 1, word, index + 1)
                    || checkWord(mat, i, j - 1, word, index + 1);
        }
        else
            return false;
    }


}
