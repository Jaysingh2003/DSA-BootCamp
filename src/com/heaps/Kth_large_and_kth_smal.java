package com.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/// Find the kth smallest and kth largest element in an array
public class Kth_large_and_kth_smal {

    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();

    }


//    Comparator rule (important)
//	•	negative → a comes before b
//	•	zero → equal
//	•	positive → a comes after b

    ///  Note:-
    //        (b, a) -> Integer.compare(b, a)//
    //        Collections.reverseOrder()
    //bothe are same and both will create a max heap
    /// find  kth largest element in an array
    public int kthLargest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.offer(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();

    }
}