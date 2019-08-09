package trees;

import java.util.*;

/**
 * Given a set of reviews provided by the customers for different hotels and a string containing
 * “Good Words”, you need to sort the reviews in descending order according to their “Goodness
 * Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number
 * of “Good Words” in that string. Note: Sorting should be stable. If review i and review j have
 * the same “Goodness Value” then their original order would be preserved.
 *
 *  You are expected to use Trie in an Interview for such problems
 *
 * Constraints:
 *
 * 1.   1 <= No.of reviews <= 200
 * 2.   1 <= No. of words in a review <= 1000
 * 3.   1 <= Length of an individual review <= 10,000
 * 4.   1 <= Number of Good Words <= 10,000
 * 5.   1 <= Length of an individual Good Word <= 4
 * 6.   All the alphabets are lower case (a - z)
 * Input:
 *
 * S : A string S containing "Good Words" separated by  "_" character. (See example below)
 * R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_"
 * character.
 * Output:
 *
 * A vector V of integer which contain the original indexes of the reviews in the sorted order
 * of reviews.
 *
 * V[i] = k  means the review R[k] comes at i-th position in the sorted order.
 * (See example below)
 * In simple words, V[i]=Original index of the review which comes at i-th position in the
 * sorted order. (Indexing is 0 based)
 * Example:
 *
 * Input:
 * S = "cool_ice_wifi"
 * R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]
 *
 * Output:
 * ans = [2, 0, 1]
 * Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
 */
public class HotelReviews {
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
                if (current.children[letter - 'a'] == null){
                    current.children[letter - 'a'] = new TrieNode(letter);
                }
                current = current.children[letter - 'a'];
            }
            ++current.freq;
        }

        public boolean checkWord(String word){
            TrieNode current = root;
            for (char letter : word.toCharArray()){
                if (current.children[letter - 'a'] == null){
                    return false;
                }
                current = current.children[letter - 'a'];
            }
            if (current.freq > 0) return true;
            return false;
        }
    }

    public static void main(String[] args){
        List<String> reviews = Arrays.asList("water_is_cool", "cold_ice_drink",
                "cool_wifi_speed");
        String d = "cool_ice_wifi";
        System.out.println(countReviews(reviews, d));
    }

    public static ArrayList<Integer> countReviews(List<String> reviews, String dict){
        Trie dictTrie = new Trie();
        for (String word : dict.split("_")){
            dictTrie.addWord(word);
        }

        List<String> reviewsNew = new ArrayList<>(reviews);

        Collections.sort(reviewsNew, (o1, o2) -> {
            int count1 = 0, count2 = 0;
            for (String word : o1.split("_")){
                if (dictTrie.checkWord(word)) ++count1;
            }
            for (String word : o2.split("_")){
                if (dictTrie.checkWord(word)) ++count2;
            }
            return count1 - count2;
        });

        System.out.println(reviewsNew);

        ArrayList<Integer> sol = new ArrayList<>();
        for (String review : reviewsNew){
            for (int i = reviews.size() - 1; i >= 0; --i){
                if (review.equals(reviews.get(i))){
                    sol.add(0, i);
                    break;
                }

            }
        }
        return sol;
    }

}
