package com.searching;

public class SearchInrange {
    public static void main(String[] args) {

        int[] arr ={1,2,3,4,5,5,5,34,7};
        int target=34;
        int start=1;
        int end=5;

        System.out.println(search(arr,target,1,5));

    }
    static  int  search(int[] arr ,int target, int start, int end){
        if(arr.length==0){
            return -1;
        }
        for (int i = start; i < end ;i++) {
            if(arr[i]==target){
                return i;
            }

        }
        return -1;
    }
}
