package com.tree;


import java.util.Scanner;

public class BineryTree {

    private static  class Node{
        int value;
        Node left;
        Node right;

        public Node (int value){
        this.value= value;
        }
    }

    private Node root;

    /// insert the element in the tree
    public void  populateTree(Scanner scanner){
        System.out.print("Enter the value of the rootnode: ");
        int rootValue = scanner.nextInt();
        root = new Node(rootValue);//root node is created


    }
    //for the insert of the element in the tree using the recursion
    public void populate(Scanner scanner, Node node){
        System.out.printf(" Do ypu n to insert the left node: ");
        boolean left = scanner.nextBoolean();
        if(left){//if left is true then
            System.out.printf("Enter the value of the left node: ");
            int leftValue = scanner.nextInt();
            node.left = new Node(leftValue);
            populate(scanner, node.left);
        }else{
            System.out.printf("Do you want to insert the right node: ");
            boolean right = scanner.nextBoolean();
            if(right){
            System.out.printf("Enter the value of the right node: ");
            int rightValue = scanner.nextInt();
            node.right = new Node(rightValue);
            populate(scanner, node.right);
            }
        }
        }

}
