package com.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Merge_K_Sorted_array {
    /// brute force approach
    /// time -> O(N log N) where N is the total number of elements in all the arrays combined.
    /// space -> O(N) for the merged array.
    public int[] mergeKSortedArrays(List<List<Integer>> lists) {
        int totalSize = 0;
        for (List<Integer> list : lists) {
            totalSize += list.size();
        }

        int[] result = new int[totalSize];
        int index = 0;

        for (List<Integer> list : lists) {
            for (int num : list) {
                result[index++] = num;
            }
        }

        // Sort the merged array
        Arrays.sort(result);
        return result;
    }

    /// Approach 2: Using a min heap (priority queue)
//    step-1: Create a min heap to store the smallest elements from each array.
//    step-2: Initialize the min heap with the first element of each array.
//    step-3: Extract the minimum element from the heap and add it to the result.
//    step-4: If there are more elements in the same array, add the next element to the heap at the time when we remove the element from the array.
//    step-5: Repeat steps 3 and 4 until the heap is

    /// optimal approach using min heap
    /// time -> O(N log k) where N is the total number of elements in all the arrays combined and k is the number of arrays.
    /// space -> O(k) for the min heap.
    /// N is the no of eleemnt and for the (poll() → log K  and 	offer() → log K) and we are doing this for N elements so O(N log K)
    class HeapNode {
        int value; // the value of the element
        int arrayIndex; // the index of the array from which the element is taken
        int elementIndex; // the index of the element in its respective array

        public HeapNode(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public int[] mergeKSortedArraysOptimal(List<List<Integer>> lists) {

        List<Integer> result = new ArrayList<>();
        // Create a min heap to store the smallest elements from each array
        PriorityQueue<HeapNode> minHeap = new java.util.PriorityQueue<>((a, b) -> a.value - b.value);

        // Initialize the min heap with the first element of each array
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new HeapNode(lists.get(i).get(0), i, 0));
            }

        }

        // Extract the minimum element from the heap and add it to the result
        while (!minHeap.isEmpty()) {
            HeapNode node = minHeap.poll();// Get the smallest element
            result.add(node.value);// Add it to the result
            int nextElementIndex = node.elementIndex + 1;// Get the index of the next element in the same array
            // If there are more elements in the same array, add the next element to the heap
            if (nextElementIndex < lists.get(node.arrayIndex).size()) {//We don’t go out of bounds,  The list still has elements left
                minHeap.offer(new HeapNode(// now, Push next element into heap
                        lists.get(node.arrayIndex).get(nextElementIndex),
                        node.arrayIndex,
                        nextElementIndex));
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    /// method-3  using the array
//    public class MergeKSortedArrays {
//
//        public static List<Integer> merge(int[][] arrays) {
//            List<Integer> result = new ArrayList<>();
//
//            PriorityQueue<HeapNode> minHeap =
//                    new PriorityQueue<>((a, b) -> a.value - b.value);
//
//            // push first element of each array
//            for (int i = 0; i < arrays.length; i++) {
//                if (arrays[i].length > 0) {
//                    minHeap.offer(new HeapNode(arrays[i][0], i, 0));
//                }
//            }
//
//            while (!minHeap.isEmpty()) {
//                HeapNode curr = minHeap.poll();
//                result.add(curr.value);
//
//                int nextIndex = curr.elementIndex + 1;
//                if (nextIndex < arrays[curr.arrayIndex].length) {
//                    minHeap.offer(new HeapNode(
//                            arrays[curr.arrayIndex][nextIndex],
//                            curr.arrayIndex,
//                            nextIndex
//                    ));
//                }
//            }
//
//            return result;
//        }
//    }
}
