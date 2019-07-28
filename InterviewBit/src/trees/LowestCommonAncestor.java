package trees;

/**
 *
 * Find the lowest common ancestor in an unordered binary tree given
 * two values in the tree.
 *
 * Lowest common ancestor : the lowest common ancestor (LCA) of two
 * nodes v and w in a tree or directed acyclic graph (DAG) is the lowest
 * (i.e. deepest) node that has both v and w as descendants.
 *
 * Example :
 *
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2_     0        8
 *          /   \
 *          7    4
 * For the above tree, the LCA of nodes 5 and 1 is 3.
 *
 * LCA = Lowest common ancestor
 * Please note that LCA for nodes 5 and 4 is 5.
 *
 * You are given 2 values. Find the lowest common ancestor of the two nodes
 * represented by val1 and val2. No guarantee that val1 and val2 exist in the
 * tree. If one value doesn’t exist in the tree then return -1.
 * There are no duplicate values.
 * You can use extra memory, helper functions, and can modify the node
 * struct but, you can’t add a parent pointer.
 *
 */
public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public int lca(TreeNode A, int B, int C) {
        if(!doesExist(A, B) || !doesExist(A, C)) {
            return -1;
        }

        TreeNode ans = lcaImpl(A, B, C);
        return ans == null ? -1 : ans.val;
    }

    public TreeNode lcaImpl(TreeNode A, int B, int C) {
        if (A == null) return null;

        if (A.val == B || A.val == C) {
            return A;
        }

        TreeNode l = lcaImpl(A.left, B, C);
        TreeNode r = lcaImpl(A.right, B, C);

        if (l != null && r != null) {
            return A;
        }

        return l != null ? l : r;
    }

    public boolean doesExist(TreeNode root, int num) {
        if (root == null) return false;
        if (root.val == num) return true;

        return doesExist(root.left, num) || doesExist(root.right, num);
    }
}
