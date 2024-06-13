package com.heaps;

import java.util.ArrayList;

public class Max_Heap<T extends Comparable<T>> {

    private ArrayList<T> heap;// we use arraylist to store the heap elements

    public Max_Heap() {// constructor
        heap = new ArrayList<>();
    }

    private void swap(int i, int j) {/// swap method to swap the elements in the heap
        T temp = heap.get(i);
        heap.set(i, heap.get(j));///Take the value at index j and  Put it at index i
        heap.set(j, temp);
    }

    /// we use zero based index
    private int parent(int index) {/// parent method to get the parent index of a given index
        return (index - 1) / 2;
    }

    private int left(int index) {/// leftChild method to get the left child index of a given index
        return 2 * index + 1;
    }

    private int right(int index) {/// rightChild method to get the right child index of a given index
        return 2 * index + 2;
    }

    /// insert
    public void insert(T value) {
        heap.add(value);
        int i = heap.size() - 1;      // index of new element

        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) > 0) {// while new element is greater than parent then swap
            swap(i, parent(i));       // swap with parent
            i = parent(i);            // move up
        }
    }

    /// removeMax
    public T remove() throws Exception {
        if (heap.size() == 0) {
            throw new Exception("Heap is empty");
        }
        T max = heap.get(0);          // get max element
        T last = heap.remove(heap.size() - 1); // remove last element
        if (heap.size() > 0) {
            heap.set(0, last);        // move last to root
            downheap(0);               // heapify from root
        }
        return max;
    }

    public void downheap(int index) {// swap only when the child is greater than the parent
        int max = index;
        int left = left(index);
        int right = right(index);

        if (left < heap.size() && heap.get(left).compareTo(heap.get(max)) > 0) {// if left child is greater than parent then max becomes left
            max = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(max)) > 0) {// if right child is greater than parent then max becomes right
            max = right;
        }
        /// /// If max changes, we swap the current node with the larger child and continue downheap from the new position.”
        if (max != index) {
            swap(index, max);
            downheap(max);
        }
    }



}
