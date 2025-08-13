package com.functions;

import java.util.*;

public class Main {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();
        Node parent;

        Node(String name) {
            this.name = name;
            this.parent = null;
        }
    }

    public static Node buildTree(List<String> lines) {
        Map<String, Node> nodes = new HashMap<>();
        Node root = null;

        for (String line : lines) {
            String[] parts = line.split(" ");
            String parentPath = parts[0];

            nodes.putIfAbsent(parentPath, new Node(parentPath.substring(parentPath.lastIndexOf('/') + 1)));
            if (root == null) root = nodes.get(parentPath);

            for (int i = 1; i < parts.length; i++) {
                String childPath = parentPath.equals("root") ? "root/" + parts[i] : parentPath + "/" + parts[i];
                nodes.putIfAbsent(childPath, new Node(parts[i]));
                Node child = nodes.get(childPath);
                child.parent = nodes.get(parentPath);
                nodes.get(parentPath).children.add(child);
            }
        }
        return root;
    }

    public static Node findNode(Node root, String path) {
        if (root == null) return null;
        if (path.equals("root")) return root;

        String[] parts = path.split("/");
        Node current = root;

        for (int i = 1; i < parts.length; i++) {
            boolean found = false;
            for (Node child : current.children) {
                if (child.name.equals(parts[i])) {
                    current = child;
                    found = true;
                    break;
                }
            }
            if (!found) return null;
        }
        return current;
    }

    public static int countDescendants(Node node) {
        if (node == null) return 0;
        int count = 0;
        for (Node child : node.children) {
            count += 1 + countDescendants(child);
        }
        return count;
    }

    public static boolean isAncestor(Node src, Node dest) {
        Node curr = dest;
        while (curr != null) {
            if (curr == src) return true;
            curr = curr.parent;
        }
        return false;
    }

    public static int countNodes(Node node) {
        if (node == null) return 0;
        int count = 1;
        for (Node child : node.children) {
            count += countNodes(child);
        }
        return count;
    }

    public static Node cloneSubtree(Node src) {
        Node newNode = new Node(src.name);
        for (Node child : src.children) {
            Node clonedChild = cloneSubtree(child);
            clonedChild.parent = newNode;
            newNode.children.add(clonedChild);
        }
        return newNode;
    }

    public static boolean cutPaste(Node root, String srcPath, String destPath) {
        Node src = findNode(root, srcPath);
        Node dest = findNode(root, destPath);

        if (src == null || dest == null || src == dest || isAncestor(src, dest)) return false;
        for (Node child : dest.children) {
            if (child.name.equals(src.name)) return false;
        }

        src.parent.children.remove(src);
        src.parent = dest;
        dest.children.add(src);

        if (countNodes(root) > 1000000) {
            dest.children.remove(src);
            return false;
        }
        return true;
    }

    public static boolean copyPaste(Node root, String srcPath, String destPath) {
        Node src = findNode(root, srcPath);
        Node dest = findNode(root, destPath);

        if (src == null || dest == null || src == dest || isAncestor(src, dest)) return false;
        for (Node child : dest.children) {
            if (child.name.equals(src.name)) return false;
        }

        Node newNode = cloneSubtree(src);
        newNode.parent = dest;
        dest.children.add(newNode);

        if (countNodes(root) > 1000000) {
            dest.children.remove(newNode);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();

        List<String> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lines.add(sc.nextLine());
        }

        Node root = buildTree(lines);

        for (int i = 0; i < q; i++) {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            String op = parts[0];

            if (op.equals("countDescendants")) {
                String path = parts[1];
                Node target = findNode(root, path);
                if (target != null) {
                    System.out.println(countDescendants(target));
                } else {
                    System.out.println("Invalid command");
                }
            } else if (op.equals("cutPaste")) {
                String srcPath = parts[1];
                String destPath = parts[2];
                if (cutPaste(root, srcPath, destPath)) {
                    System.out.println("OK");
                } else {
                    System.out.println("Invalid command");
                }
            } else if (op.equals("copyPaste")) {
                String srcPath = parts[1];
                String destPath = parts[2];
                if (copyPaste(root, srcPath, destPath)) {
                    System.out.println("OK");
                } else {
                    System.out.println("Invalid command");
                }
            }
        }
    }
}