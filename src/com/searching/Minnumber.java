package com.searching;
//return the minimum no  among the given array
public class Minnumber {
    public static void main(String[] args) {
        int[] arr ={1,-2,3,4,5,6,6,5};
        System.out.println(minnumber(arr));

    }
    static  int minnumber(int[] arr){
        int ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < ans){
              ans=arr[i];
            }
        }
        return ans;
    }
}
