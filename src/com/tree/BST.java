package com.tree;

public class BST {
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

    public BST() {//default constructor

    }

    /// find the height nof the node
    public int height(Node node) {//height is leaf node to that node height
        if (node == null) {
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

    /// insert fxn
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {//if node is null then create a new node and return it
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        /// 1 is added here because the height  is calculated upto the root one more edge is extra added
        node.height = Math.max(height(node.left), height(node.right) + 1);

        return node;//if the node has already value then return the node
    }

    /// chack the teree is balanced or not
    public boolean isBalanced() {
        return isBalanced(root);
    }
    private boolean isBalanced(Node node) {
        if(node==null){
            return true;
        }
        /// first it calculate the root left right height difference then it check for left and right subtree
        return Math.abs(height(node.left)-height(node.right))<=1 && isBalanced(node.left) && isBalanced(node.right);
    }



    /// display the tree
    public void display() {
        display(root, "root node");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.printf(details, node.value);
        display(node.left, "left node of" + node.value);//becouse the details is type of string
        display(node.right, "right node of" + node.value);
    }


}
