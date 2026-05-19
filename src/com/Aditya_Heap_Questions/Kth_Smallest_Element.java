package com.Aditya_Heap_Questions;
import java.util.PriorityQueue;

public class Kth_Smallest_Element {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);//for reverse order or max heap
        int n = arr.length;
        for (int i = 0; i < n; i++) {
           if(pq.size() < k){
               pq.add(arr[i]);
           }else if(pq.peek() > arr[i]){
               pq.poll();
               pq.add(arr[i]);
           }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }
}
