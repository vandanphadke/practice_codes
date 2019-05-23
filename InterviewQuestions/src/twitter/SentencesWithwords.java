package twitter;

import java.util.*;

public class SentencesWithwords {

    public static void textQueries(List<String> sentences, List<String> queries){
        HashMap<String, Integer>[] wordsSentencesMap = new HashMap[sentences.size()];
        for (int i = 0 ; i < sentences.size(); ++i){
            wordsSentencesMap[i] = new HashMap<>();
        }

        for (int i = 0; i < sentences.size(); ++i){
            String[] sentence = sentences.get(i).split(" ");
            for (String word: sentence){
                if (wordsSentencesMap[i].containsKey(word)){
                    wordsSentencesMap[i].put(word, wordsSentencesMap[i].get(word) + 1) ;
                }
                else {
                    wordsSentencesMap[i].put(word,1);
                }
            }
        }

        System.out.println(Arrays.toString(wordsSentencesMap));

        for (String queryWords: queries){
            String[] queryWordsSplit = queryWords.split(" ");
            StringBuilder sb = new StringBuilder();
            boolean found = true;
            for (int j = 0; j < sentences.size(); ++j) {
                HashMap<String, Integer> sentMap = wordsSentencesMap[j];
                for (int k = 0 ; k < queryWordsSplit.length; ++k){
                    if (!sentMap.containsKey(queryWordsSplit[k])){
                        found = false;
                        break;
                    }
                    else {
                        int freq = sentMap.get(queryWordsSplit[k]);
                        for (int l = 0; l < freq; ++l){
                            sb.append(j + " ");
                        }
                    }
                }
            }
            if (found) {
                System.out.println(sb.toString().trim());
            }
            sb = new StringBuilder();
        }
    }


    public static void main(String[] args){
        List<String> sentences = new ArrayList<>();
        sentences.add("jim abcd efgh john jim jim");
        sentences.add("jim john asd sadsa");
        sentences.add("osids john adsijd");
        List<String> queries = new ArrayList<>();
        queries.add("jim john");
        textQueries(sentences, queries);

    }

}
