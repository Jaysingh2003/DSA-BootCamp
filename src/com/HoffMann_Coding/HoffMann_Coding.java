package com.HoffMann_Coding;

import java.util.*;

public class HoffMann_Coding {

    /// encoder and decoder maps for character to code and code to character
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    /// crateing the node
    private class Node implements Comparable<Node> {
        Character data;
        int cost;// frequency
        Node left;
        Node right;

        public Node(Character data, int cost) {
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        /// Note we have to override the CompareTo method to compare the cost of the nodes for the min heap
        /// beacvouse if be compare the two node then java get confused   what to comapere in Node that is why we have to iverride the comaore to mathod to compare the cost of the node
        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;//Negative → this object is SMALLER than other//
            // 	Zero → this object is EQUAL to other//	Positive → this object is GREATER than other
        }
    }

    /// constructor to create the encoder and decoder maps
    public HoffMann_Coding(String feeder) throws Exception {
        HashMap<Character, Integer> fmap = new HashMap<>();

        // step-1 count the frequency of each character in the feeder string and store it in the fmap
        for (char cc : feeder.toCharArray()) {
            fmap.put(cc, fmap.getOrDefault(cc, 0) + 1);
        }


        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        // step-2  create a node for each character and its frequency and add it to the min heap
        for (Map.Entry<Character, Integer> entry : fmap.entrySet()) {/// iterate through the fmap and create a node for each character and its frequency and add it to the min heap
            Node node = new Node(entry.getKey(), entry.getValue());/// create a node for each character and its frequency
            minHeap.offer(node);// add the node to the min heap
        }

        //step-3:  take 2 node combine them and create a new node with the sum of the costs of the 2 nodes and add it to the min heap
        // and repeat this process until there is only one node in the min heap that will be the root of the huffman tree
        while (minHeap.size() != 1) {// while there is more than one node in the min heap
            Node first = minHeap.poll();// remove the first node from the min heap
            Node second = minHeap.poll();// remove the second node from the min heap

            Node newNode = new Node('\0', first.cost + second.cost);// create a new node with the sum of the costs of the first and second nodes
            newNode.left = first;// set the left child of the new node to the first node
            newNode.right = second;// set the right child of the new node to the second node

            minHeap.offer(newNode);// add the new node to the min heap
        }

        // step-4: the last node in the min heap will be the root of the huffman tree --> we will use this root to create the encoder and decoder maps
        Node root = minHeap.poll();

        encoder = new HashMap<>();// initialize the encoder map
        decoder = new HashMap<>();// initialize the decoder map

    }
    /// step-5: create the encoder and decoder maps by traversing the huffman tree and assigning a code to each character based on the path taken to reach the character (left = 0, right = 1)
    private void encoder(Node node, String code) {// recursive method to create the encoder and decoder maps
        if (node == null) {
            return;
        }

        if (node.data != '\0') {//if we ar at the leaf node then we will add the character and its code to the encoder and decoder maps
            encoder.put(node.data, code);/// add the character and its code to the encoder map
            decoder.put(code, node.data);/// add the code and its character to the decoder map
        }

        encoder(node.left, code + "0");
        encoder(node.right, code + "1");
    }

    /// step-6: encode the input string by replacing each character with its corresponding code from the encoder map
    public String encode(String str) {
        String ans = "";
        for (char cc : str.toCharArray()) {
            ans += encoder.get(cc);//encoder.get(cc) will return the code for the character cc from the encoder map and we will concatenate it to the ans string
        }
        return ans;
    }

    /// step-7: decode the encoded string by replacing each code with its corresponding character from the decoder map
    public String decode(String codeString) {
        String ans = "";
        String code = "";
        for (char cc : codeString.toCharArray()) {
            code += cc;// we will concatenate the current character to the code string until we find a code that is present in the decoder map
            if (decoder.containsKey(code)) {// if the code is present in the decoder map then we will add the corresponding character to the ans string and reset the code string to empty
                ans += decoder.get(code);// decoder.get(code) will return the character for the code from the decoder map and we will concatenate it to the ans string
                code = "";// reset the code string to empty
            }

        }
        return ans;
    }
}