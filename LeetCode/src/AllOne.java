import java.util.*;

/**
 * Implement a data structure supporting the following operations:
 *
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is
 * guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an
 * existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed
 * to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an
 * empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an
 * empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */
public class AllOne {
    // TODO Updating minimum in case min object is removed and we want to find the
    // TODO next minimum (Can't do this in O(1))
    public static void main(String[] args){
        AllOne a = new AllOne();
        a.inc("a");a.inc("b");a.inc("b");
        a.inc("c");a.inc("c");a.inc("c");
        System.out.println(a.numFreq);
        System.out.println(a.freqNum);
        a.dec("b");
        a.dec("b");
        System.out.println(a.getMinKey());
        a.dec("a");
        System.out.println(a.getMaxKey());
        System.out.println(a.getMinKey());
    }


    Map<String, Integer> numFreq;
    Map<Integer, Set<String>> freqNum;
    int min, max;

    /** Initialize your data structure here. */
    public AllOne() {
        this.min = 1;
        this.max = 1;
        this.numFreq = new HashMap<>();
        this.freqNum = new HashMap<>();
        this.freqNum.put(1, new HashSet<>());
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (this.numFreq.containsKey(key)){
            int count = this.numFreq.get(key);
            this.numFreq.put(key, count + 1);
            this.freqNum.get(count).remove(key);
            if (!this.freqNum.containsKey(count + 1)){
                this.freqNum.put(count + 1, new HashSet<>());
                this.max = count + 1;
            }
            this.freqNum.get(count + 1).add(key);
            if (this.min == count && this.freqNum.get(count).size() == 0){
                ++this.min;
            }
        }
        else {
            this.numFreq.put(key, 1);
            this.freqNum.get(1).add(key);
            this.min = 1;
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (this.numFreq.containsKey(key)){
            int count = this.numFreq.get(key);
            if (count != 1){
                this.numFreq.put(key, count - 1);
            }
            this.freqNum.get(count).remove(key);
            if (count != 1)
                this.freqNum.get(count - 1).add(key);
            if (this.max == count && this.freqNum.get(count).size() == 0){
                --this.max;
            }
            if (this.min == count && this.freqNum.get(count).size() == 0){
                --this.min;
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(this.freqNum.get(this.max).size() == 0) return "";
        else
            return this.freqNum.get(this.max).iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(this.freqNum.get(this.min).size() == 0) return "";
        else
            return this.freqNum.get(this.min).iterator().next();
    }
}
