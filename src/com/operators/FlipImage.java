package com.operators;
//https://leetcode.com/problems/flipping-an-image/submissions/1746196875/
class FlipImage {
    public static void main(String[] args) {


    }
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row:image){
            //revers an array
            for (int i=0; i < (image[0].length +1) / 2; i++){
                int temp = row[i] ^ 1;//we can use XOR to invert 0 to 1 and 1 to 0
                row[i] = row[image[0].length -1 -i] ^ 1;//invert and assign
                row[image[0].length -1 -i] = temp;
            }
        }
        return image;
    }
}