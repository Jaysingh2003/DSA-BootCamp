package com.recursion_pattern;


import java.util.Arrays;

//you can se the bubble sort concept in recursion pattern question -Triangle_Pattern question in the same package
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int n = arr.length;
        bubblesort(arr, n - 1, 0);
        System.out.println(Arrays.toString(arr));

    }

    static void bubblesort(int[] arr, int l, int r) {//l is for number of passes and r is for comparison in each pass
        if (l == 0) {                               //l is like the row and r is like the column think like 2d array
            return;
        }
        if (l > r) {//l start from the n-1 so l jyada rahega every pass me kuki row sorted hota jayega and uski lenth
                    //kam hot jayega
            if (arr[r] > arr[r + 1]) {
                //swap
                int temp = arr[r];
                arr[r] = arr[r + 1];
                arr[r + 1] = temp;
            }
            bubblesort(arr, l, r + 1);
        } else {
            bubblesort(arr, l - 1, 0);
        }
    }
}
