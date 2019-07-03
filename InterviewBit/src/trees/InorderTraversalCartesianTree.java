package trees;


import java.util.List;

public class InorderTraversalCartesianTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode construct(List<Integer> inorder){
        return constructCartesianTree(inorder, 0, inorder.size() - 1);
    }



    public TreeNode constructCartesianTree(List<Integer> inorder, int startIndex, int endIndex){
        if (startIndex > endIndex) return null;

        int max = Integer.MIN_VALUE, maxIndex = 0;
        for (int i = startIndex; i <= endIndex; ++i){
            if (inorder.get(i) > max){
                max = inorder.get(i);
                maxIndex = i;
            }
        }

        TreeNode currentRoot = new TreeNode(maxIndex);
        currentRoot.left = constructCartesianTree(inorder, startIndex, maxIndex - 1);
        currentRoot.right = constructCartesianTree(inorder, maxIndex + 1, endIndex);
        return currentRoot;
    }



}
