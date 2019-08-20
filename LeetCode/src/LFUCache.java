import java.util.*;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should
 * support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the
 * cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache
 * reaches its capacity, it should invalidate the least frequently used item before inserting
 * a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys
 * that have the same frequency), the least recently used key would be evicted.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 */
public class LFUCache {
    int capacity;
    int minFreq;
    Map<Integer, Integer> lookup;
    Map<Integer, Integer> frequency;
    /**
     * Why was LinkedHashSet used here instead of HashSet?
     * This is to take care of cases where multiple keys have the same access frequency. In that
     * case we have to remove the one which was added earlier (least recently used), so insertion
     * order becomes important hence LinkedHashSet.
     */
    Map<Integer, LinkedHashSet<Integer>> freqKey;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = -1;
        this.lookup = new HashMap<>();
        this.frequency = new HashMap<>();
        this.freqKey = new HashMap<>();
    }

    public int get(int key) {
        if (!lookup.containsKey(key)){
            return -1;
        }
        int count = frequency.get(key);
        int nextCount = count + 1;
        this.frequency.put(key, nextCount);

        if (!freqKey.containsKey(nextCount)){
            freqKey.put(nextCount, new LinkedHashSet<>());
        }
        freqKey.get(nextCount).add(key);
        freqKey.get(count).remove(key);
        if(count == this.minFreq && freqKey.get(this.minFreq).size() == 0){
            ++this.minFreq;
        }
        return lookup.get(key);
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) return;
        if (lookup.containsKey(key)){
            lookup.put(key, value);
            get(key);
        }
        else {
            if (lookup.size() >= capacity){
                int nextMin = freqKey.get(this.minFreq).iterator().next();
                freqKey.get(this.minFreq).remove(nextMin);
                lookup.remove(nextMin);
                frequency.remove(nextMin);
            }
            this.lookup.put(key, value);
            this.frequency.put(key, 1);
            if (!this.freqKey.containsKey(1)){
                this.freqKey.put(1, new LinkedHashSet<>());
            }
            this.freqKey.get(1).add(key);
            this.minFreq = 1;
        }
    }
}
