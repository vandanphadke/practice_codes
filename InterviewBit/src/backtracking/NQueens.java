package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such
 * that no two queens attack each other.
 *
 * N Queens: Example 1
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens’
 * placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 *
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueens {
    public static void main(String[] args){
        System.out.println(solve(4));
    }

    public static ArrayList<ArrayList<String>> solve(int n){
        List<Integer> queens = new ArrayList<>();
        for (int i = 0; i < n; ++i) queens.add(-1);
        List<List<Integer>> res = new ArrayList<>();
        nqueensrecurse(queens, 0, n, res);
        return placeQueens(res, n);
    }

    public static ArrayList<ArrayList<String>> placeQueens(List<List<Integer>> result, int n){
        ArrayList<ArrayList<String>> finalRes = new ArrayList<>();
        for (List<Integer> arr : result){
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < arr.size(); ++i){
                int place = arr.get(i);
                char[] queens = new char[n];
                Arrays.fill(queens, '.');
                queens[place] = 'Q';
                res.add(new String(queens));
            }
            finalRes.add(res);
        }
        return finalRes;
    }

    public static boolean nqueensrecurse(List<Integer> queens, int index, int n,
                                         List<List<Integer>> results){
        if (index == n){
            results.add(new ArrayList<>(queens));
            return true;
        }
        for (int i = 0; i < n; ++i){
            queens.set(index, i);
            if (!checkBoard(queens, index, i)){
                continue;
            }
            nqueensrecurse(queens, index + 1, n, results);
        }
        return true;
    }


    public static boolean checkBoard(List<Integer> queens, int indexX, int indexY){
        for (int i = 0; i < indexX; ++i){
            if (queens.get(i) == indexY)
                return false;

            if (indexX - i == Math.abs(indexY - queens.get(i)))
                return false;
        }
        return true;
    }
}
