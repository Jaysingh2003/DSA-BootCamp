package com.array;

public class Maxelement {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,66,87,45};
        System.out.println(max(arr));

    }
    static int max(int[] arr){
        int maxval=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>maxval){
                maxval=arr[i];
            }
        }
       return maxval;
    }
}
