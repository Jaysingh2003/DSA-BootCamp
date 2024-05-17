package com;

import java.util.Arrays;


/// Radix Sort is a non-comparative integer sorting algorithm that sorts numbers by processing individual digits.
///  It works by grouping numbers based on their digits and sorting them in multiple passes, starting from the least significant digit to the most significant digit. The algorithm uses a stable sorting method, such as counting sort, to sort the digits at each pass. Radix Sort is efficient for sorting large sets of integers and can achieve linear time complexity under certain conditions.
public class Radix_Sort {
    public static void radixSort(int[] arr) {

        /// step 1: find the maximum number in the array
        int max = Arrays.stream(arr).max().getAsInt();
//      int max = arr[0];//tradittional way to find the maximum number in the array
//      for (int num : arr) {
//          if (num > max) {
//              max = num;
//          }
//      }

        /// step-2  do count sort for every digit place. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        for(int exp = 1; max/exp > 0; exp *= 10) {//in the first itration it check the unit place, then the tens place and so on until it reaches the most significant digit
            countSort(arr, exp);
        }
    }

    ///step-3: count sort for the given digit place.
    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for(int i=0; i<n; i++) {
            count[(arr[i] / exp) % 10]++;//it counts the occurrences of each digit in the current place value (unit, tens, etc.) and stores it in the count array
        }

        System.out.println("\nCount array for " + exp + " : " + Arrays.toString(count));

        for(int i=1; i<10; i++) {//
            count[i] = count[i] + count[i-1];
        }

        System.out.println("Updated count array " + Arrays.toString(count));

        for(int i=n-1; i>=0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.out.println("Output array " + Arrays.toString(output));

        System.arraycopy(output, 0, arr, 0, n);

    }

    public static void main(String[] args) {
        int[] arr = {29, 83, 471, 36, 91, 8};

        System.out.println("Origin array: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
