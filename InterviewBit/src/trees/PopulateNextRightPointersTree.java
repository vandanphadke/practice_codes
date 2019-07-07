package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree
 *
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 *
 * Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 *  Note:
 * You may only use constant extra space.
 * Example :
 *
 * Given the following binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 *  Note 1: that using recursion has memory over
 *
 */
public class PopulateNextRightPointersTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int val){
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

    public void populateQueue(TreeNode root){
        if (root == null) return;

        Queue<NodeLevel> levelQueue = new LinkedList<>();
        levelQueue.add(new NodeLevel(root, 0));

        while (!levelQueue.isEmpty()){
            NodeLevel current = levelQueue.poll();
            if (!levelQueue.isEmpty()){
                NodeLevel next = levelQueue.peek();
                if (next.level == current.level){
                    current.node.next = next.node;
                }
            }

            if (current.node.left != null){
                levelQueue.add(new NodeLevel(current.node.left, current.level + 1));
            }

            if (current.node.right != null){
                levelQueue.add(new NodeLevel(current.node.right, current.level + 1));
            }
        }
    }

    /* Currently this is not working */
    public void populateConstant(TreeNode root){
        TreeNode prev = root, current;
        while (prev != null){
            current = prev;
            while (current != null){
                if (current.left != null){
                    if (current.right != null){
                        current.left.next = current.right;
                    }
                    else {
                        if (current.next != null){
                            if (current.next.left != null){
                                current.left.next = current.next.left;
                            }
                            else if (current.next.right != null){
                                current.left.next = current.next.right;
                            }
                        }
                    }
                }
                else if (current.right != null){
                    if (current.next != null){
                        if (current.next.left != null){
                            current.right.next = current.next.left;
                        }
                        else if (current.next.right != null){
                            current.right.next = current.next.right;
                        }
                    }
                }
                current = current.next;
            }
            prev = prev.left;
        }
    }

}
