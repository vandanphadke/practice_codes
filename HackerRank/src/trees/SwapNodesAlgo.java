package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SwapNodesAlgo {

    static class Node {
        int data;
        Node left;
        Node right;
        int depth;

        public Node(int data, int depth){
            this.data = data;
            this.left = null;
            this.right = null;
            this.depth = depth;
        }
    }


    public static void inorder(Node node){
        if (node == null)
            return;

        inorder(node.left);

        System.out.print(node.data + " ");

        inorder(node.right);
    }


    public static void swapNodeatLevel(Node head, int depth){
        Queue<Node> levelQueue = new LinkedList<>();
        levelQueue.offer(head);

        while (!levelQueue.isEmpty()){
            Node current = levelQueue.poll();
            Node left = current.left;
            Node right = current.right;

            if (current.depth % depth == 0){

                if (left != null && right != null){
                    Node temp = current.left;
                    current.left = current.right;
                    current.right = temp;
                    levelQueue.offer(current.left);
                    levelQueue.offer(current.right);
                }
                else if (left != null && right == null){
                    current.right = current.left;
                    current.left = null;
                    levelQueue.offer(current.right);
                }
                else if(left == null && right != null){
                    current.left = current.right;
                    current.right = null;
                    levelQueue.offer(current.left);
                }
            }
            else {
                if (left != null)
                    levelQueue.offer(left);
                if (right != null)
                    levelQueue.offer(right);
            }


        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Node> nodeQueue = new LinkedList<Node>();
        Node head = new Node(1, 1);
        nodeQueue.add(head);

        for (int i = 0 ; i < n; ++i){
            String[] content = br.readLine().split(" ");

            int left = Integer.parseInt(content[0]);
            int right = Integer.parseInt(content[1]);

            Node current = nodeQueue.poll();
            if (left != -1){
                current.left = new Node(left, current.depth + 1);
                nodeQueue.offer(current.left);
            }


            if (right != -1){
                current.right = new Node(right, current.depth + 1);
                nodeQueue.offer(current.right);
            }

        }

        /*inorder(head);
        System.out.println();

        swapNodeatLevel(head, 2);

        inorder(head);*/

        int swaps = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < swaps; ++i){
            int k = Integer.parseInt(br.readLine());
            swapNodeatLevel(head, k);
            inorder(head);
            System.out.println();
        }
    }

}
