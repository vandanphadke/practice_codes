import java.util.*;

/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another
 * user and is able to see the 10 most recent tweets in the user's news feed. Your design should
 * support the following methods:
 *
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user
 * herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 *
 * Twitter twitter = new Twitter();
 *
 * // User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 *
 * // User 1 follows user 2.
 * twitter.follow(1, 2);
 *
 * // User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
 *
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 *
 * // User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
 *
 * // User 1's news feed should return a list with 1 tweet id -> [5],
 * // since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 */
public class DesignTwitter {
    Map<Integer, Integer> tweets;
    Map<Integer, Set<Integer>> followers;
    List<Integer> tweetsFeed;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        tweets = new HashMap<>();
        followers = new HashMap<>();
        tweetsFeed = new ArrayList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweets.put(tweetId, userId);
        tweetsFeed.add(tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news
     * feed must be posted by users who the user followed or by the user herself. Tweets must
     * be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        int totalFeeds = 0;
        List<Integer> results = new ArrayList<>();
        for(int i = tweetsFeed.size() - 1; i >= 0; --i){
            int user = tweets.get(tweetsFeed.get(i));
            if(user == userId || ( followers.containsKey(userId) && followers.get(userId).contains(user))){
                results.add(tweetsFeed.get(i));
                ++totalFeeds;
                if(totalFeeds == 10)
                    break;
            }
        }
        return results;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(followers.containsKey(followerId))
            followers.get(followerId).remove(followeeId);
    }
}
