package com.tree;

import java.util.ArrayList;
import java.util.List;
//Morris traversal performs inorder traversal by creating temporary threads using inorder predecessors,
// allowing traversal in O(1) extra space without recursion or a stack.
public class Morris_Traversal_constatent_space {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> morristreaversal(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = node;
        while (curr != null) {
            if (curr.left == null) {//no left subtree
                list.add(curr.val);
                curr = curr.right;

            } else {//finding inorder predecessor->predsessor means left subtree ka rightmost node
                TreeNode ipred = curr.left;
                while (ipred.right != null && ipred.right != curr) {
                    ipred = ipred.right;
                }

                if (ipred.right == null) {//it means thread is not created yet and we have to craete thread
                    ipred.right = curr;//thread create
                    curr = curr.left;//move to left subtree
                } else {//it means thread is already created and we have to break the thread)
                    ipred.right = null;//break the thread
                    list.add(curr.val);//add the value
                    curr = curr.right;//move to right subtree
                }

            }
        }
        return list;
    }
}
