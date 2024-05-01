package com.Aditya_Heap_Questions;

import java.util.*;
public class FrequencySort_alternatives {
    public static void frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Max Heap based on frequency
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        // Add all unique elements
        maxHeap.addAll(map.keySet());
        // Print result
        while (!maxHeap.isEmpty()) {
            int num = maxHeap.poll();
            int freq = map.get(num);
            for (int i = 0; i < freq; i++) {
                System.out.print(num + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        frequencySort(arr);
    }
}
