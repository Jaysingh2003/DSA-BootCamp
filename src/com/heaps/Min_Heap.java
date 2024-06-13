package com.heaps;

import java.util.ArrayList;

///  Heap<T extends Comparable<T>> its an genric and used to compare with the two objects
public class Min_Heap<T extends Comparable<T>> {
    private ArrayList<T> heap;// we use arraylist to store the heap elements

    public Min_Heap() {// constructor
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
        heap.add(value);              // add at end
        int i = heap.size() - 1;      // index of new element
        /// compareTo  >  returns < 0 → a is smaller than b
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) < 0) {// while new element is smaller than parent then swap
            swap(i, parent(i));       // swap with parent
            i = parent(i);            // move up
        }
    }

    /// removeMin
    ///  see the diagram how yo remove the elemt like last element ko root par rakh do and then downheap kar do
    public T remove() throws Exception {
        if (heap.size() == 0) {
            throw new Exception("Heap is empty");
        }
        T min = heap.get(0);          // get min element
        T last = heap.remove(heap.size() - 1); // remove last element
        if (heap.size() > 0) {
            heap.set(0, last);        // move last to root
            downheap(0);               // heapify from root
        }
        return min;
    }

    public void downheap(int index) {
        int min = index;// assume current index is min
        int left = left(index);
        int right = right(index);
        //left < heap.size() to check if left child exists
        if (left < heap.size() && heap.get(left).compareTo(heap.get(min)) < 0) {// left child is smaller
            min = left;///if left is samller then update min to left index
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(min)) < 0) {// right child is smaller
            min = right;///if left is samller then update min to right index
        }

        /// If min changes, we swap the current node with the smaller child and continue downheap from the new position.”
        if (min != index) { // if min is not the current index means
            swap(index, min); // swap with smaller child
            downheap(min); // heapify down from new position
        }

    }

    /// HeapSort
    /// the time complxity in heap sort is O(n log n) because we remove n elements and
    /// each remove operation takes O(log n) time to maintain the heap property.
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while (!heap.isEmpty()) {
            data.add(this.remove());//this refers to the current object of the class. But here ❌ NO — not mandatory
        }
        return data;
    }


    public static void main(String[] args) throws Exception {
        Min_Heap<Integer> minHeap = new Min_Heap<>();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);

        System.out.println(minHeap.remove());
        System.out.println(minHeap.remove());

    }


}