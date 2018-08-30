import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Vandan
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 * Design an algorithm to serialize and deserialize a binary search tree.
 *
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string
 * and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 */
public class SerializeandDeserializeBST {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        String serialized = serialize(root);
        System.out.println(serialized);
        TreeNode x = deserialize(serialized);
        System.out.println(x.left.val);
        System.out.println(x.right.val);

    }


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        Queue<Pair> nodesQueue = new LinkedList<>();
        nodesQueue.offer(new Pair(root, 0));
        int currentlevel = 0;
        String s = "";
        while (!nodesQueue.isEmpty()){
            Pair current = nodesQueue.poll();
            if (currentlevel != current.level){
                s = s + "X";
                s = s + current.t.val + ",";
                ++currentlevel;
            }
            else {
                if (current.t != null)
                    s = s + current.t.val + ",";
            }

            if (current != null && current.t.left != null)
                nodesQueue.offer(new Pair(current.t.left, current.level + 1));

            if (current != null && current.t.right != null)
                nodesQueue.offer(new Pair(current.t.right, current.level + 1));

        }
        return s;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] levels = data.split("X");
        String rootStr = levels[0];
        rootStr = rootStr.substring(0, rootStr.length() - 1);
        TreeNode root = new TreeNode(Integer.parseInt(rootStr));
        for (int i = 1; i < levels.length; ++i){
            String[] keys = levels[i].split(",");
            for (String key: keys){
                if (key.endsWith(",")) {
                    key = key.substring(0, key.length() - 1);
                }
                bstInsert(root, Integer.parseInt(key));
            }

        }
        return root;
    }

    public static TreeNode bstInsert(TreeNode node, int data){
        if (node == null)
            node = new TreeNode(data);
        else {
            TreeNode current = node ;
            TreeNode parent = node ;
            while(current != null){
                parent = current ;
                if(current.val < data)
                    current = current.right;
                else if(current.val > data)
                    current = current.left;
                else
                    break ;
            }
            if(parent.val < data)
                parent.right = new TreeNode(data);
            else
                parent.left = new TreeNode(data);
        }
        return node;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Pair {
    TreeNode t;
    int level;

    Pair(TreeNode t, int level){
        this.level = level;
        this.t = t;
    }
}