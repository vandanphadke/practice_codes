package hashing;

import java.util.HashMap;

/**
 *
 * Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 *
 * Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.
 *
 *  NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * Example :
 *
 * Input :
 *          capacity = 2
 *          set(1, 10)
 *          set(5, 12)
 *          get(5)        returns 12
 *          get(1)        returns 10
 *          get(10)       returns -1
 *          set(6, 14)    this pushes out key = 5 as LRU is full.
 *          get(5)        returns -1
 *
 */
public class LRUCache {

    int capacity;
    int currentCount;
    HashMap<Integer, Node> lookup;
    Node head = null;
    Node tail = null;

    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.value = value;
            this.key = key;
        }

    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.currentCount = 0;
        lookup = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    // TODO Handle case when a duplicate key is trying to be added
    public void set(int key, int value){

        // Insert node at head
        if (this.head == null){
            this.head = new Node(key, value);
            this.lookup.put(key, this.head);
            this.tail = this.head;
        }
        else {
            Node newNode = new Node(key, value);
            newNode.next = head;
            this.head.prev = newNode;
            this.head = newNode;
            this.lookup.put(key, newNode);
        }

        ++this.currentCount;

        // Remove tail if capacity is reached
        if (this.currentCount > this.capacity){
            Node prev = this.tail.prev;
            lookup.remove(this.tail.key);
            prev.next = null;
            this.tail.prev = null;
            this.tail = prev;
        }

    }

    /**
     * Returns the lookup value for the entry
     * Also removes the current block and
     * attaches it to the head of the linked list
     *
     * @param key
     * @return value for this entry
     */
    public int get(int key){
        if (!lookup.containsKey(key)){
            return -1;
        }

        Node currentNode = lookup.get(key);

        if (currentNode != this.head){

            if (currentNode.next == null){
                Node prev = currentNode.prev;
                prev.next = null;
                this.tail = prev;
            }
            else {
                Node prev = currentNode.prev;
                Node next = currentNode.next;

                prev.next = next;
                next.prev = prev;
            }

            currentNode.next = this.head;
            this.head.prev = currentNode;
            currentNode.prev = null;

            this.head = currentNode;
        }

        return currentNode.value;
    }

}
