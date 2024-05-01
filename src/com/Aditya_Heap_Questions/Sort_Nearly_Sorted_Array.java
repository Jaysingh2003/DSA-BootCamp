package com.Aditya_Heap_Questions;

import java.util.PriorityQueue;


public class Sort_Nearly_Sorted_Array {
    public static void sortArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();///minheap
        int n = arr.length;
        for (int i = 0; i <= k; i++) {///k lenth tak hi array ek bari me lena h bas
            pq.add(arr[i]);
        }
        int index = 0;///usi array emsave karne ke liye
        for (int i = k + 1; i < n; i++) {
            arr[index++] = pq.poll();///top ka minimum elamnet array me sova ker denge jo ki array sport ho jaye
            pq.add(arr[i]);
        }
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }

    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        sortArray(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
