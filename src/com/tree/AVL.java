package com.tree;

public class AVL {
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {//constructor
            this.value = value;
        }

        public int getValue() {//getter
            return value;
        }
    }

    private Node root;

    public AVL() {//default constructor

    }

    public int height() {
        return height(root);
    }
    /// find the height nof the node
    public int height(AVL.Node node) {//height is calclated by >  leaf node to that node height
        if (node == null) {///suppose if any node has the left child and its right child  not  > then -1 is used for the right child
            return -1;
        }
        return node.height;

    }
    /// check if the tree is empty or not
    public void isEmpty() {
        if (root == null) {
            return;
        }
    }

    /// chack the teree is balanced or not
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(AVL.Node node) {
        if (node == null) {
            return true;
        }
        /// +1 Adds one edge (the connection to the child) to get the height for the current node.
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void populatedTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.insert(arr[i]);
        }
    }

    /// populate for the sorted array-> 1,2,3,4,5,6,..
    public void populatedSortedTree(int[] arr) {
        populatedTree(arr, 0, arr.length - 1);
    }
    private void populatedTree(int[] arr, int start, int end) {
        if (start > end) {//it will stop becouse the end  value become -1 at a time  so no element is there to insert
            return;
        }
        int mid = (start + end) / 2;
        insert(arr[mid]);
        populatedTree(arr, start, mid - 1);
        populatedTree(arr, mid + 1, end);
    }

    /// insert fxn
    public void insert(int value) {
        root = insert(root, value);
    }
    private Node insert(Node node, int value) {
        if (node == null) {//if node is null then create a new node and return it
            return new Node(value);
        }
        //node.left is equal to what ever you retun from  here  -> insert(node.left, value)
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        //while you are traversing the tree the height of the tree is changing
        /// 1 is added here because the height  is calculated upto the root one more edge is extra added
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotate(node);//rotate method take the node rotate it and return the node
    }

    //when you recursibly call the fxn it will goes from the bottom to up and the it will pring the node
    private Node rotate(Node node) {/// it will return thr node because it will accept the node of the insertion
        if (height(node.left) - height(node.right) > 1) {//it will check if tree is unbalnaced
            /// apply four cases of rotation
            if (height(node.left.left) - height(node.left.right) > 0) {//left left case
                return rightRotate(node);
            }
            if (height(node.left.right) - height(node.left.left) < 0) {//left right case
                node.left = leftRotate(node.left);//niche wale (child ke) ko left rotate kro
                return rightRotate(node);//parent ko right ki taraf rotate karege
            }
        }
        if (height(node.left) - height(node.right) < -1) {//means the right tree is more that one level below the left tree
            /// apply four casses of rotation
            if (height(node.right.left) - height(node.right.right) < 0) {//left left case
                return leftRotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0) {//left right case
                node.right = rightRotate(node.right);//niche wale (child ke) ko right rotate kro
                return leftRotate(node);//parent ko left ki taraf rotate karege
            }
        }
        return node;//nothing to rotate the return the node as it is
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;
       //after rearrangment
        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return c;
    }

    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        //after rearrangment
        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    //run the fxn

    public static void main(String[] args) {
        AVL tree = new AVL();
        for (int i = 0; i < 1000 ; i++) {
             tree.insert(i);
        }
        System.out.println(tree.isBalanced());
        System.out.println(tree.height());
    }

}



