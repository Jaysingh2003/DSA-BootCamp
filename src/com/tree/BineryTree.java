package com.tree;

import java.util.Scanner;

public class BineryTree {

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {///constructor
            this.value = value;
        }
    }

    private Node root;

    // Insert the root node
    public void populateTree(Scanner scanner) {
        System.out.print("Enter the value of the root node: ");
        int rootValue = scanner.nextInt();
        root = new Node(rootValue);
        populate(scanner, root);
    }

    // Recursively insert elements
    public void populate(Scanner scanner, Node node) {
        System.out.print("Do you want to insert the left node of " + node.value + "? (true/false): ");
        boolean left = scanner.nextBoolean();//write true of false
        if (left) {//if left is true then
            System.out.print("Enter the value of the left node: ");
            int leftValue = scanner.nextInt();
            node.left = new Node(leftValue);
            populate(scanner, node.left);
        }

        System.out.print("Do you want to insert the right node of " + node.value + "? (true/false): ");
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.print("Enter the value of the right node: ");
            int rightValue = scanner.nextInt();
            node.right = new Node(rightValue);
            populate(scanner, node.right);
        }
    }

    // Display the tree
    public void display() {///overloading
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");//here \t is tab character
        display(node.right, indent + "\t");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BineryTree tree = new BineryTree();
        tree.populateTree(scanner);
        tree.display();
    }
}
