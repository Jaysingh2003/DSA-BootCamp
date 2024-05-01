package com.Aditya_Heap_Questions;

import java.util.*;

class Pair1 {

    int num;
    int freq;

    Pair1(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}

public class Top_K_Frequent_Numbers {

    // Frequency Count
    public static List<Pair1> countFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],
                    map.getOrDefault(arr[i], 0) + 1);
        }
        List<Pair1> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new Pair1(key, map.get(key)));
        }
        return list;
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Pair1> frequency = countFrequency(nums);
        // Min Heap based on frequency
        PriorityQueue<Pair1> minHeap =///onm the bassis of frquency comapared
                new PriorityQueue<>(
                        (a, b) -> a.freq - b.freq
                );
        for (int i = 0; i < frequency.size(); i++) {
            if (minHeap.size() < k) {
                minHeap.add(frequency.get(i));
            } else {
                if (frequency.get(i).freq >
                        minHeap.peek().freq) {
                    minHeap.poll();
                    minHeap.add(frequency.get(i));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll().num);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(
                topKFrequent(arr, k)
        );
    }
}