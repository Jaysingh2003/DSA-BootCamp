package com.heaps;


/// idea :-“I start from the last non-leaf node (n/2 − 1) and apply max-heapify downward using left and right child formulas.”
public class Convert_Min_Heap_To_Max_Heap {
    public static void convertMinToMaxHeap(int[] heap) {
        int n = heap.length;

        // Start from last non-leaf node
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(heap, n, i);
        }
    }

    private static void maxHeapify(int[] heap, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < n && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            // Heapify affected subtree
            maxHeapify(heap, n, largest);
        }
    }
}
