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

    /// find the height -> it does not calculate the height of the tree it only return the alredy calcuted height of the node like getter for displaying the height
    public int height(Node node) {//height is calclated by >  leaf node to that node height or be can sey (how maney edges between them)
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


    public void populatedTree(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            this.insert(arr[i]);
        }
    }
    /// populate for the sorted array-> 1,2,3,4,5,6,.. if not do that then the tree will be skewed tree
    public void populatedSortedTree(int[] arr) {
        populatedTree(arr, 0, arr.length - 1);
    }
    private void populatedTree(int[] arr, int start, int end) {
        if (start > end) {//it will stop becouse the end  value become -1 at a time  so no element is there to insert
            return;
        }
        int mid = (start + end) / 2;
        insert(arr[mid]);
        populatedTree(arr, start, mid - 1);// stop of left Recurse left → populatedTree(arr, 0, -1) means when only one elemt
                                                // are left the  we have to  go upto the  mid -1 so 0-1 id the -1 ( stat 0, end -1 -> means start> end)
        populatedTree(arr, mid + 1, end);
    }

    /// insert fxn
    public void insert(int value) {
        root = insert(root, value);
    }
    /// 1-> Node root = null -> 2 - insert(10) -> root = insert(null, 10) -> return new Node(10) -> root = Node(10)
    private Node insert(Node node, int value) {
        if (node == null) {//if node is null then create a new node and return it like a leaf node
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
        return node;//if the node has already value then return the node
    }

    /// chack the teree is balanced or not
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        /// +1 Adds one edge (the connection to the child) to get the height for the current node.
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }


    /// for the display of the tree
    public void display() {
        display(this.root, "Root node:");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "left node of " + node.value + " : ");//becouse the details is type of string
        display(node.right, "right node of " + node.value + " : ");
    }
    public static void main(String[] args) {
        BST tree = new BST();
        int[] arr = {10, 5, 15, 3, 7, 18, 1, -1};
        tree.populatedTree(arr);
        tree.display();

    }

    ///  Traversal techniques

    ///preorder traversal
    public void preOrderTraversal(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    /// inOrderTraversal
    /// it will give the sorted order of the element in the BST
    public void inOrderTraversal(){

        inOrderTraversal(root);
    }
    private void inOrderTraversal(Node node){
        if(node==null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value);
        inOrderTraversal(node.right);
    }

    ///postorder
    public void postOrderTraversal(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);

    }
}
