package com.operators;

//we have to find the no whic are no repeated in the array

public class Duplicatenumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3}; // Example array with a duplicate
        int duplicate = findDuplicate(arr);
        System.out.println("The duplicate number is: " + duplicate);
    }
   static int findDuplicate(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int expectedSum = (n - 1) * n / 2; // Sum of first n-1 natural numbers
        return sum - expectedSum; // The difference will be the duplicate number
    }

}
