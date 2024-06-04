package com.boutnous_acciolite;

import java.util.*;

public class FrequencySortPQ {

    public static void main(String[] args) {

        int[] arr = {4, 5, 6, 5, 4, 3};

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: PriorityQueue with proper comparator logic
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {

            int freqCompare = Integer.compare(map.get(b), map.get(a));
            // If b has higher frequency → positive → b comes first (max heap behavior)

            if (freqCompare != 0) {// If frequency different → sort by frequency
                return freqCompare;
            }

           // If frequency same → sort by value ascending
            return Integer.compare(a, b);
        });

        pq.addAll(map.keySet());

        // Step 3: Build result
        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            int num = pq.poll();
            int freq = map.get(num);

            for (int i = 0; i < freq; i++) {
                result.add(num);
            }
        }

        System.out.println(result);
    }
}