package com.Aditya_Heap_Questions;

import java.util.PriorityQueue;
public class Return_K_largest_Elements_in_array {
    public static int[] klargest(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[k];
        // Min Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++){
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else {///it means if size is equal or grteater than k then
                if (pq.peek() < arr[i]) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
    }
        while(pq.size()>0)

    {
        ans[--k] = pq.poll();

    }

        return ans;
}

public static void main(String[] args) {
    int[] arr = {7, 10, 4, 3, 20, 15};
    int k = 3;
    int[] ans = klargest(arr, k);
    for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i] + " ");
    }

}
}
