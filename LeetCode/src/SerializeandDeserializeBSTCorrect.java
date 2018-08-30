import java.util.Stack;
import java.util.stream.Stream;

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
public class SerializeandDeserializeBSTCorrect {

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        String serialized = serialize(root);
        System.out.println(serialized);

        TreeNode root1 = deserialize(serialized);
        System.out.println(root1.val);
        System.out.println(root1.left.val);
        System.out.println(root1.right.val);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return preorderTraversal(root).trim();
    }

    public static String preorderTraversal(TreeNode node){
        if (node == null)
            return "";

        String s = node.val + " ";

        s = s + preorderTraversal(node.left);
        s = s + preorderTraversal(node.right);

        return s;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] levels = data.split(" ");
        int[] values = Stream.of(levels).mapToInt(Integer::parseInt).toArray();
        return constructTree(values);

    }

    public static TreeNode constructTree(int pre[]) {

        // The first element of pre[] is always root
        TreeNode root = new TreeNode(pre[0]);

        Stack<TreeNode> s = new Stack<TreeNode>();

        // Push root
        s.push(root);

        // Iterate through rest of the size-1 items of given preorder array
        for (int i = 1; i < pre.length; ++i) {
            TreeNode temp = null;

            /* Keep on popping while the next value is greater than
             stack's top value. */
            while (!s.isEmpty() && pre[i] > s.peek().val) {
                temp = s.pop();
            }

            // Make this greater value as the right child and push it to the stack
            if (temp != null) {
                temp.right = new TreeNode(pre[i]);
                s.push(temp.right);
            }

            // If the next value is less than the stack's top value, make this value
            // as the left child of the stack's top node. Push the new node to stack
            else {
                temp = s.peek();
                temp.left = new TreeNode(pre[i]);
                s.push(temp.left);
            }
        }

        return root;
    }

}
