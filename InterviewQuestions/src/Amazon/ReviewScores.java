package Amazon;

import java.util.*;

//23280673603334
class ProductReviewScore{
    public int productid;
    public double reviewScore;

    public ProductReviewScore(int id, double value){
        this.productid = id;
        this.reviewScore = value;
    }
}

public class ReviewScores {

    public Map<Integer, Double> calculateHighestFive(int scoreCount,
                                                     ArrayList<ProductReviewScore>
                                                             reviewScoresOfProduct){

        HashMap<Integer, PriorityQueue<Double>> reviewsMap = new HashMap<>();

        for (ProductReviewScore currentScore: reviewScoresOfProduct){
            int prodId = currentScore.productid;
            if (reviewsMap.containsKey(prodId))
                reviewsMap.get(prodId).add(currentScore.reviewScore);
            else {
                PriorityQueue<Double> sc = new PriorityQueue<>(scoreCount, Collections.reverseOrder());
                sc.add(currentScore.reviewScore);
                reviewsMap.put(prodId, sc);
            }
        }

        Map<Integer, Double> results = new HashMap<>();
        for (Integer currentId: reviewsMap.keySet()){
            PriorityQueue<Double> currentQueue = reviewsMap.get(currentId);
            double score = 0;
            for (int i = 0; i < 5; ++i){
                score += currentQueue.poll();
            }
            double average = score/5;
            results.put(currentId, average);
        }
        return results;
    }
}
