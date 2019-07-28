package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find shortest unique prefix to represent each word in the list.
 *
 * Example:
 *
 * Input: [zebra, dog, duck, dove]
 * Output: {z, dog, du, dov}
 * where we can see that
 * zebra = z
 * dog = dog
 * duck = du
 * dove = dov
 *
 */
public class ShortestUniquePrefix {
    private static final int MAX_CHARACTERS = 26;

    static class TrieNode {
        char c;
        int freq;
        TrieNode[] children;

        public TrieNode(char c){
            this.c = c;
            this.freq = 0;
            this.children = new TrieNode[MAX_CHARACTERS];
        }
    }

    static class Trie{
        TrieNode root;

        public Trie(){
            this.root = new TrieNode(' ');
        }

        public void addWord(String word){
            TrieNode current = root;
            for (char letter : word.toCharArray()){
                ++current.freq;
                if (current.children[letter - 'a'] == null){
                    current.children[letter - 'a'] = new TrieNode(letter);
                }
                current = current.children[letter - 'a'];
            }
        }

        public String getUnique(String word){
            TrieNode current = root;
            int i = 0;
            while (current != null && i < word.length() && current.freq > 1){
                current = current.children[word.charAt(i) - 'a'];
                ++i;
            }
            return word.substring(0, i);
        }
    }


    public static List<String> getUniquePrefix(List<String> words){
        Trie trie = new Trie();
        for (String word : words)
            trie.addWord(word);

        ArrayList<String> result = new ArrayList<>();
        for (String word : words)
            result.add(trie.getUnique(word));

        return result;
    }

    public static void main(String[] args){
        List<String> arr = Arrays.asList("zebra", "dog", "duck", "dove");
        System.out.println(getUniquePrefix(arr));
    }
}
