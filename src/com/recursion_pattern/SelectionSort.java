package com.recursion_pattern;


import java.util.Arrays;

//sismilar to the buuble sort  and in everyfxn call we have to track the largest elemnt
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 2, 1};
        selectionsort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));

    }

    static void selectionsort(int[] arr, int r, int c, int max) {//r is the row or we can it is no of passes
        //c is the column or we can say it is the index for comparision
        //max is the index of the largest element
        if (r == 0) {
            return;
        }
        if (c < r) {//note this will fail when c is equal to r means the last element then we simply swap it with the max element
            if (arr[c] > arr[max]) { //max is the index of the largest element att everyb pass we asssume the
                //first element is the largest and then we compare it with the rest of the elements

                selectionsort(arr, r, c + 1, c);//intially max and c is has zero index value means there compere with the same elemnts
            } else {
                selectionsort(arr, r, c + 1, max);
            }
        } else { //when one pass is end then we have to place the max element at the end
            //swap
            int temp = arr[max];
            arr[max] = arr[r - 1];//for swapping the largest element with the last element of the unsorted array
            arr[r - 1] = temp;
            selectionsort(arr, r - 1, 0, 0);
        }


    }
}
