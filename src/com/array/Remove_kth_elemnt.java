package com.array;

import java.util.*;

public class Remove_kth_elemnt {

    public static int kthLargest(int[] arr, int k) {
        if (k <= 0 || k > arr.length) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            pq.add(num);///it will automatically kepp the top elemnt smallest

            if (pq.size() > k) {//if size is greater than k then remove the smallest element
                pq.poll(); // remove smallest
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input k
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = kthLargest(arr, k);

        if (result == -1) {
            System.out.println("Invalid k value");
        } else {
            System.out.println("Kth Largest Element: " + result);
        }

        sc.close();
    }
}