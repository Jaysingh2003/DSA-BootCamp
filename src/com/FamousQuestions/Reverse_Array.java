package com.FamousQuestions;

public class Reverse_Array {
    // Function to reverse the array in place
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    //using the temp array
    public int[] reverseArray1(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            temp[j-1] = arr[i];
            j = j-1;
        }
        return temp;
    }




    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
