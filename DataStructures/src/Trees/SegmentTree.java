package Trees;

/**
 * Let us consider the following problem to understand Segment Trees.
 *
 * We have an array arr[0 . . . n-1]. We should be able to
 * 1 Find the sum of elements from index l to r where 0 <= l <= r <= n-1
 *
 * 2 Change value of a specified element of the array to a new value x.
 * We need to do arr[i] = x where 0 <= i <= n-1.
 *
 * Representation of Segment trees
 * 1. Leaf Nodes are the elements of the input array.
 * 2. Each internal node represents some merging of the leaf nodes.
 * The merging may be different for different problems. For this problem,
 * merging is sum of leaves under a node.
 */
public class SegmentTree {

    int n;
    int[] treeArr;
    public SegmentTree(int[] arr, int n){
        this.n = n;
        this.treeArr = new int[n];
        constructTree(arr, 0, n - 1, 0);
    }

    private int getMid(int start, int end){
        return start + ((end - start)/2);
    }

    private int constructTree(int arr[], int segStart, int segEnd, int segIndex) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (segStart == segEnd) {
            treeArr[segIndex] = arr[segStart];
            return arr[segIndex];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(segStart, segEnd);
        treeArr[segIndex] = constructTree(arr, segStart, mid, segIndex * 2 + 1) +
                constructTree(arr, mid + 1, segEnd, segIndex * 2 + 2);
        return treeArr[segIndex];
    }

    public int getSum(int queryStart, int queryEnd){
        return getSumRecurse(queryStart, queryEnd, 0, this.n - 1, 0);
    }

    private int getSumRecurse(int queryStart, int queryEnd,
                              int segStart, int segEnd, int segIndex){
        if (segStart >=  queryStart && segEnd <= queryEnd){
            return this.treeArr[segIndex];
        }
        //if (segStart < queryStart || segEnd)
        return 0;
    }
}
