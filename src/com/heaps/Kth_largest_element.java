package com.heaps;

import java.util.ArrayList;


/// Use this solution only when it saya use the Implement using heap / don’t use library”
public class Kth_largest_element<T extends Comparable<T>> {

    private ArrayList<T> heap;

    public Kth_largest_element() {
        heap = new ArrayList<>();
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;

    }

    // insert method for max heap
    public void insert(T value) {
        heap.add(value);
        int i = heap.size() - 1;
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    // remove method for max heap
    public T remove() throws Exception {
        if (heap.size() == 0) {
            throw new Exception("Heap is empty");
        }
        T max = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, last);
            downheap(0);
        }
        return max;
    }

    public void downheap(int index) {
        int max = index;
        int left = left(index);
        int right = right(index);
        if (left < heap.size() && heap.get(left).compareTo(heap.get(max)) > 0) {
            max = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(max)) > 0) {
            max = right;
        }
        if (max != index) {
            swap(index, max);
            downheap(max);
        }
    }


    public T findkthlargest(T[] arr, int k) {
        for (T value : arr) {
            insert(value);
        }
        T kthLargest = null;
        for (int i = 0; i < k; i++) {
            try {
                kthLargest = remove();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return kthLargest;
    }
}
