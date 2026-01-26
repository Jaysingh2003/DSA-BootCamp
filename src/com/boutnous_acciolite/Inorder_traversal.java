package com.boutnous_acciolite;

public class Inorder_traversal {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {//constructor
            this.value = value;
        }

        public int getValue() {//getter
            return value;
        }
    }

    private Node root;

   public Inorder_traversal(Node root) {
        this.root = root;
    }

    ///  Traversal techniques
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
