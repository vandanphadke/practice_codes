import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Q:
 *
 * T9: On old cell phones, users typed on a numeric keypad and the phone would provide a list of words
 * that matched these numbers. Each digit mapped to a set of O - 4 letters. Implement an algorithm
 * to return a list of matching words, given a sequence of digits. You are provided a list of valid words
 * (provided in whatever data structure you'd like).
 *
 *
 * Here I'll assume that the words are provided in an array of tries where the head node of the trie has
 * the starting letter of each word.
 *
 */
public class FindT9Matches {

    static char[][] t9Letters = {
            null,
            null,
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}};

    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.insertWord("tree");
        dict.insertWord("used");
        dict.insertWord("cat");
        dict.insertWord("bat");

        int[] typed = {2,2,8};
        generateCombinations(dict.root, "", typed, 0);



    }

    public static void generateCombinations(TrieNode current, String currentString, int[] number, int currentIndex){
        if (currentIndex == number.length && current.isEnd){
            System.out.println(currentString);
            return;
        }

        char[] possibleChars = t9Letters[number[currentIndex]];
        for (int i = 0 ; i < possibleChars.length; ++i){
            if (current.children[possibleChars[i] - 'a'] != null){
                String newString = currentString + possibleChars[i];
                generateCombinations(current.children[possibleChars[i] - 'a'], newString, number, currentIndex + 1);
            }
        }
    }

}

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        this.children = new TrieNode[25];
        Arrays.fill(this.children, null);
        this.isEnd = false;
    }
}

class Trie {

    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }


    public void insertWord(String word){
        int len = word.length();
        TrieNode current = root;
        for (int level = 0; level < len; ++level){
            int index = word.charAt(level) - 'a';
            if (current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean searchWord(String word){
        int len = word.length();
        TrieNode current = root;
        for (int level = 0; level < len; ++level){
            int index = word.charAt(level) - 'a';
            if (current.children[index] == null){
                return false;
            }
            current = current.children[index];
        }

        if (current != null && current.isEnd)
            return true;
        else
            return false;
    }

}