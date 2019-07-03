package trees;

import java.util.*;

/**
 * Given a binary tree, return a 2-D array with vertical order traversal of it.
 * Go through the example and image for more details.
 *
 * Example :
 * Given binary tree:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 *
 * returns
 *
 * [
 *     [2],
 *     [3],
 *     [6 5],
 *     [7],
 *     [9]
 * ]
 *
 */

class NodeObj{
    TreeNode node;
    int verticalLevel;

    public NodeObj(TreeNode node, int level){
        this.node = node;
        this.verticalLevel = level;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }
}

public class VerticalOrderTraversal {

    public static ArrayList<ArrayList<Integer>> getVerticalOrder(TreeNode root){
        Queue<NodeObj> nodesQueue = new LinkedList<>();
        nodesQueue.add(new NodeObj(root, 0));

        HashMap<Integer, ArrayList<Integer>> levelLists = new HashMap<>();
        while (!nodesQueue.isEmpty()){
            NodeObj current = nodesQueue.poll();
            if (!levelLists.containsKey(current.verticalLevel)){
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(current.node.val);
                levelLists.put(current.verticalLevel, newList);
            }
            else {
                levelLists.get(current.verticalLevel).add(current.node.val);
            }
            if (current.node.left != null)
                nodesQueue.add(new NodeObj(current.node.left, current.verticalLevel - 1));

            if (current.node.right != null)
                nodesQueue.add(new NodeObj(current.node.right, current.verticalLevel + 1));

        }

        List<Integer> levels = new ArrayList<>(levelLists.keySet());
        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;

        for (int level: levels){
            minLevel = Math.min(level, minLevel);
            maxLevel = Math.max(level, maxLevel);
        }

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int i = minLevel; i <= maxLevel; ++i){
            results.add(levelLists.get(i));
        }

        return results;
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        System.out.println(getVerticalOrder(root));
    }

}
