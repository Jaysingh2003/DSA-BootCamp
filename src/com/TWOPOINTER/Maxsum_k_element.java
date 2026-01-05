package com.TWOPOINTER;

public class Maxsum_k_element {
    public static  int sum(int[] arr, int k) {
       int i=0 ,j=0;
       int sum=0;
       int n = arr.length;
       int maxSum = Integer.MIN_VALUE;
       while(j<n){
           sum+=arr[j];///calculating sum
              if(j-i+1<k){
                j++;
              }else if(j-i+1==k){
                maxSum = Math.max(maxSum,sum);
                sum-=arr[i];///slide
                i++;
                j++;
              }
       }
       return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,1,3,2};
        int k = 3;
        System.out.println(sum(arr,k));
    }
}
