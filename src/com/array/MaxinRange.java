package com.array;

public class MaxinRange {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7,66,87,454};
        System.out.println(max(arr,1,10));

    }
    static int max(int[] arr,int first, int last){
        if(first>last){
            return -1;
        }
        if(arr==null){
            return -1;
        }
        if(arr.length==0){
            return -1;
        }
        int maxval=arr[0];
        for (int i = first; i < last; i++) {
            if(arr[i]>maxval){
                maxval=arr[i];
            }
        }
        return maxval;
    }
}
