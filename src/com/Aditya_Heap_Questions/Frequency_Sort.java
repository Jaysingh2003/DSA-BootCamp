package com.Aditya_Heap_Questions;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/// In this question we have to srot the arryon the bassis of frequecy of no's
class Pair2 {

    int num;
    int freq;

    Pair2(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }
}

public class Frequency_Sort {
    /// method-1  Frequency Count
    public static List<Pair2> countFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],
                    map.getOrDefault(arr[i], 0) + 1);
        }
        List<Pair2> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new Pair2(key, map.get(key)));
        }
        return list;
    }

    public static void frequecySort(int[] nums) {
        List<Pair2> frequency = countFrequency(nums);
        /// max Heap based on frequency
        PriorityQueue<Pair2> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (int i = 0; i < frequency.size(); i++) {
            maxHeap.add(frequency.get(i));
        }
        ///now print the element
        while (!maxHeap.isEmpty()) {
            Pair2 p = maxHeap.poll();
            for (int j = 0; j < p.freq; j++) {
                System.out.print(p.num + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
     frequecySort( arr);
    }

}
