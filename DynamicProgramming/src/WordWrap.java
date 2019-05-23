/**
 * Word Wrap problem
 *
 * Q:
 * Given a sequence of words, and a limit on the number of characters that can be put in one line (line width).
 * Put line breaks in the given sequence such that the lines are printed neatly.
 *
 * Assume that the length of each word is smaller than the line width.
 */
public class WordWrap {
    public static void main(String[] args){
        String[] line = {"aaa", "bb", "cc", "ddddd"};
        int W = 10;
        System.out.println(calculateWordWrap(line, W));
    }

    private static int calculateWordWrap(String[] line, int w) {
        int[][] cost = new int[line.length][line.length];
        for (int l = 0; l < cost.length; ++l){
            for (int i = 0 ; i < cost.length; ++i){

            }
        }


    }
}
