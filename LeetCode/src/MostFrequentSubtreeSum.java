import java.util.*;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum
 * of a node is defined as the sum of all the node values formed by the subtree rooted at that
 * node (including the node itself). So what is the most frequent subtree sum value? If there is
 * a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];
        Map<Integer, Integer> sumFreq = new HashMap<>();
        recurseSum(root, sumFreq);
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int sum : sumFreq.keySet()){
            int freq = sumFreq.get(sum);
            if (freq > max){
                max = freq;
                res.clear();
                res.add(sum);
            }
            else if (freq == max){
                res.add(sum);
            }
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; ++i)
            arr[i] = res.get(i);
        return arr;
    }

    public int recurseSum(TreeNode root, Map<Integer, Integer> sumFreq){
        int right = 0;
        if (root.right != null){
            right = recurseSum(root.right, sumFreq);
        }
        int left = 0;
        if (root.left != null){
            left = recurseSum(root.left, sumFreq);
        }
        int total = root.val + left + right;
        sumFreq.put(total, sumFreq.getOrDefault(total, 0) + 1);
        return total;
    }
}
