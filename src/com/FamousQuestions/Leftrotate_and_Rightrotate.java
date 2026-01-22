package com.FamousQuestions;

/// Left rotate an array by d elements and Right rotate an array by d elements
/// Time Complexity: O(n)
/// Space Complexity: O(1)
public class Leftrotate_and_Rightrotate {
    public static void roeteleft(int[] arr, int d){
        int n=arr.length;;
        d = d % n; // In case d is greater than n if n=5, d=7 then d=2
        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);

    }
    public static void reverse(int[] arr, int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    // Right rotate an array by d elements
    public static void roteright(int[] arr, int d){
        int n=arr.length;
        d = d % n; // In case d is greater than n if n=5, d=7 then d=2
        reverse(arr, n-d, n-1);
        reverse(arr, 0, n-d-1);
        reverse(arr, 0, n-1);
    }

}
