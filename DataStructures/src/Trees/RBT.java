package Trees;

/*
* Implementing a RED-BLACK Tree with the following operations
* Insert
* Delete
* Search
* Other operations will have the same implementation as a BST (hence not implemented here)
*
* */
public class RBT {

    public enum COLOR {
        RED, BLACK;
    }

    public class RBTNode {
        public int data;
        public RBTNode parent;
        public RBTNode left;
        public RBTNode right;
        public COLOR color;

        public RBTNode() {}

        public RBTNode(int data, COLOR color) {
            this.data = data;
            this.color = color;
            this.left = sentinel;
            this.right = sentinel;
            this.parent = sentinel;
        }
    }

    public RBTNode sentinel = new RBTNode();
    public RBTNode root;

    public RBT(int data) {
        root = new RBTNode(data, COLOR.BLACK);
    }

    public void insert(int data){
        insert(root, data);
    }

    public void insert(RBTNode node, int data) {
        RBTNode z = new RBTNode(data, COLOR.RED);
        RBTNode y = sentinel;
        RBTNode x = root;

        while (x != sentinel){
            y = x;
            if (z.data < x.data)
                x = x.left;
            else
                x = x.right;
        }
        z.parent = y;
        if (y == sentinel)
            root = z;
        else if(data < y.data)
            y.left = z;
        else
            y.right = z;

        fixRBTree(node, z);

    }

    private void fixRBTree(RBTNode node, RBTNode z) {
        while (z.parent.color == COLOR.RED) {
            if (z == z.parent.left){
                RBTNode y = z.parent.parent.right;
                if (y.color == COLOR.RED){
                    z.parent.color = COLOR.BLACK;
                    y.color = COLOR.BLACK;
                    z.parent.parent.color = COLOR.RED;
                    z = z.parent.parent;
                }
                else {

                }
            }
        }

    }


    public RBTNode search(int data) {
        return search(root, data);
    }

    public RBTNode search(RBTNode node, int data){
        while (node.data != data || node != null){
            if (node.data == data)
                return node;
            else if(node.data < data)
                node = node.right;
            else
                node = node.left;
        }
        return node;
    }

    public void leftRotate(int data){
        RBTNode x = search(data);
        RBTNode y = x.right;

        x.right = y.left;
        if (y.left != sentinel)
            y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == sentinel)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;

        y.left = x;
        x.parent = y;

    }

    public void rightRotate(int data){
        RBTNode x = search(data);
        RBTNode y = x.left;

        x.left = y.right;
        if (y.right != sentinel)
            y.right.parent = x;

        y.parent = x.parent;
        if (x.parent == sentinel)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;

        y.right = x;
        x.parent = y;

    }

}
