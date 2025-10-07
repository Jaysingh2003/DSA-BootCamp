package com.tree;

public class SegmentTree {
    class Node {

        private int value;
        private Node left;
        private Node right;
        private int startinterval;
        private int endinterval;


        public Node(int startinterval, int endinterval) {
            this.startinterval = startinterval;
            this.endinterval = endinterval;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public SegmentTree(int[] arr) {
        /// crate a tree using the array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {// base condition-> as  start and end is same arr[0,0] the it will be leaf node to return it value a t that index
            ///return the leaf node
            Node leaf = new Node(start, end);
            leaf.value = arr[start];
            return leaf;
        }///after the leaf node is created it will return the value if the parent npde by combing left and roight value
        /// crate a new node with index you are at
        Node node = new Node(start, end);
        int mid = (start + end) / 2;
        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);
        node.value = node.left.value + node.right.value;///combination of the indices
        return node;

    }

    public int query(int qsi, int qei) {
        return query(root, qsi, qei);
    }

    private int query(Node node, int qsi, int qei) {
        //outside the interval
        if (node.startinterval > qei || node.endinterval < qsi) {
            return 0;
        }
        if (node.startinterval >= qsi && node.endinterval <= qei) {//node’s range is completely inside ->The entire (queryrenage) [2,3] segment lies within [1,4]
            return node.value;
        }//partyial overlap
        return query(node.left, qsi, qei) + query(node.right, qsi, qei);

    }

    /// update
    public void update(int index, int val) {
        this.root.value = update(this.root, index, val);
    }

    private int update(Node node, int index, int val) {
        if (index >= node.startinterval && index <= node.endinterval) {
          if(index== node.startinterval && index==node.endinterval){
              node.value = val;
              return node.value;
          }else{
              int left = update(node.left, index, val);
              int right = update(node.right, index, val);
              node.value = left + right;
              return node.value;
          }

        }
        return node.value;


    }
}
