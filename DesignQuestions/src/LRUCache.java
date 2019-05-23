import java.util.HashMap;

public class LRUCache {

    public static void main(String[] args){



    }

}


class Cache {

    int capacity;
    int currentSize;
    DoublyLL dataList;
    HashMap<Integer, DoublyLLNode> lookupTable;

    public Cache(int capacity){
        this.capacity = capacity;
        this.currentSize = 0;
        this.lookupTable = new HashMap<>();
        this.dataList = new DoublyLL(capacity);
    }

    public void insertIntoCache(int key, String data){
        if (this.currentSize < this.capacity){
            DoublyLLNode stored = dataList.insert(data);
            lookupTable.put(key, stored);
        }
        else {

        }
    }

    public String fetchData(int key){
        return null;
    }

}

class DoublyLL {

    int capacity;
    int currentSize;
    DoublyLLNode head;
    DoublyLLNode tail;

    public DoublyLL(int capacity){
        this.capacity = capacity;
        this.currentSize = 0;
        this.head = null;
        this.tail = null;
    }

    public DoublyLLNode insert(String data){
        DoublyLLNode newNode = new DoublyLLNode(data);
        if (this.currentSize == 0){
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        ++this.currentSize;
        return newNode;
    }

    public void deleteLast(){
        if (this.currentSize == 0)
            return;

        if (this.currentSize == 1){
            this.head = null;
            this.tail = null;
        }
        else {
            this.head = this.head.next;
        }
        --this.currentSize;
    }


}

class DoublyLLNode {
    String data;
    DoublyLLNode prev;
    DoublyLLNode next;

    public DoublyLLNode(String data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}