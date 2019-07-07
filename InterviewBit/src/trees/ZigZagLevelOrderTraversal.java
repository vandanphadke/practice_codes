package trees;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of
 * its nodes’ values. (ie, from left to right, then right to left
 * for the next level and alternate between).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return
 *
 * [
 *          [3],
 *          [20, 9],
 *          [15, 7]
 * ]
 */
public class ZigZagLevelOrderTraversal {

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(getTraversal(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class NodeLevel {
        TreeNode node;
        int level;

        public NodeLevel(TreeNode node, int level){
            this.level = level;
            this.node = node;
        }
    }


    public static ArrayList<ArrayList<Integer>> getTraversal(TreeNode root){
        Stack<NodeLevel> s1 = new Stack<>();
        Stack<NodeLevel> s2 = new Stack<>();
        s1.push(new NodeLevel(root, 0));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> levelNodes = new HashMap<>();

        while (!s1.isEmpty() || !s2.isEmpty()){
            while (!s1.isEmpty()){
                NodeLevel current = s1.pop();
                if (!levelNodes.containsKey(current.level)){
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(current.node.val);
                    levelNodes.put(current.level, res);
                }
                else {
                    levelNodes.get(current.level).add(current.node.val);
                }

                if (current.node.left != null)
                    s2.push(new NodeLevel(current.node.left, current.level + 1));

                if (current.node.right != null)
                    s2.push(new NodeLevel(current.node.right, current.level + 1));

            }

            while (!s2.isEmpty()){
                NodeLevel current = s2.pop();
                if (!levelNodes.containsKey(current.level)){
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(current.node.val);
                    levelNodes.put(current.level, res);
                }
                else {
                    levelNodes.get(current.level). add(current.node.val);
                }
                if (current.node.right != null)
                    s1.push(new NodeLevel(current.node.right, current.level + 1));

                if (current.node.left != null)
                    s1.push(new NodeLevel(current.node.left, current.level + 1));
            }
            System.out.println(levelNodes);
        }
        int maxLevel = Integer.MIN_VALUE;
        for (int key : levelNodes.keySet()){
            if (maxLevel < key)
                maxLevel = key;
        }

        for (int i = 0; i <= maxLevel; ++i){
            result.add(levelNodes.get(i));
        }
        return result;
    }


}
