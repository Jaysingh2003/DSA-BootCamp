package com.heaps;

import java.util.*;

public class Sort_Characters_By_Frequency {


    /// brute force approach (Maintain a frequency map > Sort the characters based on frequency > Build the result string)
    /// // Overall → O(N log N)
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));// sort characters based on frequency in descending order

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();
    }

    /// optimal approach (Maintain a frequency map > Use a max heap to sort characters by frequency > Build the result string)
    /// Overall → O(N log K)
    public String frequencySort1(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap =
                new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        maxHeap.addAll(freq.keySet());

        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            sb.append(String.valueOf(c).repeat(freq.get(c)));///String.valueOf('e')  →  "e" -> Converts char → String->	Required because repeat() works on String, not char
        }///map.get('e') → 2   // frequency of 'e'

        return sb.toString();
    }

}
